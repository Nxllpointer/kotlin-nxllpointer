/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin

import org.gradle.api.attributes.Attribute

data class AttributeWithValue<T : Any>(val attribute: Attribute<T>, val value: T)

infix fun <T : Any> Attribute<T>.withValue(value: T) = AttributeWithValue(this, value)
