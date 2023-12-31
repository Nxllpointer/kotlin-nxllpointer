/*
 * Copyright 2010-2018 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.konan.target

class Platform(val configurables: Configurables) : Configurables by configurables {

    val clang: ClangArgs.Native by lazy {
        ClangArgs.Native(configurables)
    }

    val clangForJni: ClangArgs.Jni by lazy {
        ClangArgs.Jni(configurables)
    }

    val linker: LinkerFlags by lazy {
        linker(configurables)
    }
}

class PlatformManager private constructor(private val serialized: Serialized) :
    HostManager(serialized.distribution, serialized.experimental), java.io.Serializable {

    constructor(konanHome: String, experimental: Boolean = false, konanDataDir: String? = null) : this(Distribution(konanHome, konanDataDir = konanDataDir), experimental)
    constructor(distribution: Distribution, experimental: Boolean = false) : this(Serialized(distribution, experimental))

    private val distribution by serialized::distribution

    private val loaders = enabled.map {
        it to loadConfigurables(it, distribution.properties, distribution.dependenciesDir)
    }.toMap()

    private val platforms = loaders.map {
        it.key to Platform(it.value)
    }.toMap()

    fun platform(target: KonanTarget) = platforms.getValue(target)
    val hostPlatform = platforms.getValue(host)

    fun loader(target: KonanTarget) = loaders.getValue(target)

    private fun writeReplace(): Any = serialized

    private data class Serialized(
        val distribution: Distribution,
        val experimental: Boolean,
    ) : java.io.Serializable {
        companion object {
            private const val serialVersionUID: Long = 0L
        }

        private fun readResolve(): Any = PlatformManager(this)
    }
}

