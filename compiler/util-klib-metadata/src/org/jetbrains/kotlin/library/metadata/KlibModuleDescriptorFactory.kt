/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.library.metadata

import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.descriptors.ModuleCapability
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.descriptors.impl.ModuleDescriptorImpl
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.storage.StorageManager

interface KlibModuleDescriptorFactory {

    /**
     * Base method for creation of any Kotlin/Native [ModuleDescriptor].
     */
    fun createDescriptor(
        name: Name,
        storageManager: StorageManager,
        builtIns: KotlinBuiltIns,
        origin: KlibModuleOrigin,
        customCapabilities: Map<ModuleCapability<*>, Any?> = emptyMap()
    ): ModuleDescriptorImpl

    /**
     * Please use this method with care: As far as it creates an instance of [KotlinBuiltIns] it should be
     * normally used for creation of the very first (e.g. "stdlib") module in the set of created modules.
     */
    fun createDescriptorAndNewBuiltIns(
        name: Name,
        storageManager: StorageManager,
        origin: KlibModuleOrigin,
        customCapabilities: Map<ModuleCapability<*>, Any?> = emptyMap()
    ): ModuleDescriptorImpl
}
