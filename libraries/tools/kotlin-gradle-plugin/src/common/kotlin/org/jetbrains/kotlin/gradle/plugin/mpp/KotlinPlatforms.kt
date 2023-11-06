/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.jetbrains.kotlin.gradle.plugin.AttributeWithValue
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatform
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.withValue
import org.jetbrains.kotlin.konan.target.KonanTarget

object KotlinPlatforms {
    data class Native(val konanTarget: KonanTarget) : AbstractKotlinPlatform(KotlinPlatformType.native) {
        override val platformAttributes: Collection<AttributeWithValue<*>> =
            super.platformAttributes + (KotlinNativeTarget.konanTargetAttribute withValue konanTarget.name)
    }

    object Jvm : AbstractKotlinPlatform(KotlinPlatformType.jvm)

    val all = listOf<KotlinPlatform>(
        *KonanTarget.predefinedTargets.values.map { Native(it) }.toTypedArray(),
        Jvm
    )
}

abstract class AbstractKotlinPlatform(final override val platformType: KotlinPlatformType) : KotlinPlatform {
    override val platformAttributes: Collection<AttributeWithValue<*>> = listOf(
        KotlinPlatformType.attribute withValue platformType
    )
}
