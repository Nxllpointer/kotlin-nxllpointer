/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.Project
import org.gradle.api.artifacts.result.ResolvedDependencyResult
import org.gradle.api.attributes.AttributeContainer
import org.gradle.api.attributes.Category
import org.gradle.api.attributes.Usage
import org.jetbrains.kotlin.gradle.dsl.multiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.*
import org.jetbrains.kotlin.gradle.plugin.sources.internal
import org.jetbrains.kotlin.gradle.utils.LazyResolvedConfiguration
import org.jetbrains.kotlin.gradle.utils.dependencyArtifactsOrNull
import java.io.File
import java.util.*

private typealias KotlinSourceSetName = String

internal data class SourceSetVisibilityResult(
    /**
     * Names of source sets that the consumer sees from the requested dependency.
     */
    val visibleSourceSetNames: Set<String>,

    /**
     * For some of the [visibleSourceSetNames], additional artifacts may be present that
     * the consumer should read the compiled source set metadata from.
     */
    val hostSpecificMetadataArtifactBySourceSet: Map<String, File>
)

fun <T : Any> AttributeContainer.setAttributeWithValue(attributeWithValue: AttributeWithValue<T>) {
    attribute(attributeWithValue.attribute, attributeWithValue.value)
}

internal class SourceSetVisibilityProvider(
    private val project: Project
) {

    /**
     * Determine which source sets of the [resolvedRootMppDependency] are visible in the [thisSourceSet] source set.
     *
     * This requires resolving dependencies of the compilations which [thisSourceSet] takes part in, in order to find which variants the
     * [resolvedRootMppDependency] got resolved to for those compilations.
     *
     * Once the variants are known, they are checked against the [dependencyProjectStructureMetadata], and the
     * source sets of the dependency are determined that are compiled for all those variants and thus should be visible here.
     *
     * If the [resolvedRootMppDependency] is a project dependency, its project should be passed as [resolvedToOtherProject], as
     * the Gradle API for dependency variants behaves differently for project dependencies and published ones.
     */
    fun getVisibleSourceSets(
        visibleFromName: KotlinSourceSetName,
        resolvedRootMppDependency: ResolvedDependencyResult,
        dependencyProjectStructureMetadata: KotlinProjectStructureMetadata,
        resolvedToOtherProject: Boolean
    ): SourceSetVisibilityResult {
        val visibleFrom = project.multiplatformExtension.sourceSets.getByName(visibleFromName)

        val dependencyCoordinate = resolvedRootMppDependency.selected.moduleVersion!!
        val unresolvedDependency = visibleFrom.internal.resolvableMetadataConfiguration.allDependencies.first {
            it.group == dependencyCoordinate.group && it.name == dependencyCoordinate.name && it.version == dependencyCoordinate.version
        }

        val tempPlatformConfigurations = visibleFrom.platforms
            .map { platform ->
                project.configurations.create(UUID.randomUUID().toString()).apply {
                    attributes.apply {
                        attribute(Category.CATEGORY_ATTRIBUTE, project.categoryByName(Category.LIBRARY))
                        attribute(Usage.USAGE_ATTRIBUTE, KotlinUsages.consumerApiUsage(project, platform.platformType))
                        platform.platformAttributes.forEach { attributeWithValue ->
                            setAttributeWithValue(attributeWithValue)
                        }
                    }
                    dependencies.add(unresolvedDependency)
                }
            }

        val platformConfigurationsByResolvedPlatformDependency = tempPlatformConfigurations
            .map { LazyResolvedConfiguration(it) }
            .associateBy { configuration ->
                configuration.allResolvedDependencies.find { it.selected.id == resolvedRootMppDependency.selected.id }
                    ?: throw configuration.resolutionFailures.first()
            }

        val resolvedPlatformDependenciesByResolvedVariantName = platformConfigurationsByResolvedPlatformDependency.keys.associateBy {
            kotlinVariantNameFromPublishedVariantName(
                it.resolvedVariant.displayName
            )
        }

        val visibleSourceSetNames = dependencyProjectStructureMetadata.sourceSetNamesByVariantName
            .filterKeys { it in resolvedPlatformDependenciesByResolvedVariantName }
            .values.let { if (it.isEmpty()) emptySet() else it.reduce { acc, item -> acc intersect item } }

        val hostSpecificArtifactBySourceSet: Map<String, File> =
            if (resolvedToOtherProject) {
                /**
                 * When a dependency resolves to a project, we don't need any artifacts from it, we can
                 * instead use the compilation outputs directly:
                 */
                emptyMap()
            } else {
                val hostSpecificSourceSets = visibleSourceSetNames.intersect(dependencyProjectStructureMetadata.hostSpecificSourceSets)

                /**
                 * As all of the variants normally contain the same metadata for each of the relevant host-specific source sets,
                 * any of the variants that we resolved can be used, so choose the first one that satisfies both:
                 *
                 *  - it contains the host-specific source set, and
                 *  - we have resolved it for some compilation
                 */
                val someVariantByHostSpecificSourceSet =
                    hostSpecificSourceSets.associateWith { sourceSetName ->
                        dependencyProjectStructureMetadata.sourceSetNamesByVariantName
                            .filterKeys { it in resolvedPlatformDependenciesByResolvedVariantName }
                            .filterValues { sourceSetName in it }
                            .keys.first()
                    }

                someVariantByHostSpecificSourceSet.mapNotNull { (sourceSetName, variantName) ->
                    val dependency = resolvedPlatformDependenciesByResolvedVariantName.getValue(variantName)
                    val platformConfiguration = platformConfigurationsByResolvedPlatformDependency.getValue(dependency)
                    val metadataArtifact = platformConfiguration
                        // it can happen that related host-specific metadata artifact doesn't exist
                        // for example on linux machines, then just gracefully return null
                        .dependencyArtifactsOrNull(dependency)
                        ?.singleOrNull()
                        ?: return@mapNotNull null

                    sourceSetName to metadataArtifact.file
                }.toMap()
            }

        tempPlatformConfigurations.forEach { project.configurations.remove(it) }

        return SourceSetVisibilityResult(
            visibleSourceSetNames,
            hostSpecificArtifactBySourceSet
        )
    }
}

internal fun kotlinVariantNameFromPublishedVariantName(resolvedToVariantName: String): String =
    originalVariantNameFromPublished(resolvedToVariantName) ?: resolvedToVariantName
