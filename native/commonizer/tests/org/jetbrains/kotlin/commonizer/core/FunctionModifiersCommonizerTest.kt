/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.commonizer.core

import org.jetbrains.kotlin.commonizer.cir.CirFunctionModifiers
import org.junit.Test

class FunctionModifiersCommonizerTest : AbstractCommonizerTest<CirFunctionModifiers, CirFunctionModifiers>() {

    @Test
    fun allDefault() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers()
    )

    @Test
    fun allSuspend() = doTestSuccess(
        expected = mockFunctionModifiers(isSuspend = true),
        mockFunctionModifiers(isSuspend = true),
        mockFunctionModifiers(isSuspend = true),
        mockFunctionModifiers(isSuspend = true)
    )

    @Test(expected = IllegalCommonizerStateException::class)
    fun suspendAndNotSuspend() = doTestFailure(
        mockFunctionModifiers(isSuspend = true),
        mockFunctionModifiers(isSuspend = true),
        mockFunctionModifiers()
    )

    @Test(expected = IllegalCommonizerStateException::class)
    fun notSuspendAndSuspend() = doTestFailure(
        mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers(isSuspend = true)
    )

    @Test
    fun allOperator() = doTestSuccess(
        expected = mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers(isOperator = true)
    )

    @Test
    fun notOperatorAndOperator() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers(isOperator = true)
    )

    @Test
    fun operatorAndNotOperator() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers(isOperator = true),
        mockFunctionModifiers()
    )

    @Test
    fun allInfix() = doTestSuccess(
        expected = mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers(isInfix = true)
    )

    @Test
    fun notInfixAndInfix() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers(isInfix = true)
    )

    @Test
    fun infixAndNotInfix() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers(isInfix = true),
        mockFunctionModifiers()
    )

    @Test
    fun allInline() = doTestSuccess(
        expected = mockFunctionModifiers(isInline = true),
        mockFunctionModifiers(isInline = true),
        mockFunctionModifiers(isInline = true),
        mockFunctionModifiers(isInline = true)
    )

    @Test
    fun notInlineAndInline() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(),
        mockFunctionModifiers(isInline = true),
        mockFunctionModifiers(isInline = true)
    )

    @Test
    fun inlineAndNotInline() = doTestSuccess(
        expected = mockFunctionModifiers(),
        mockFunctionModifiers(isInline = true),
        mockFunctionModifiers(isInline = true),
        mockFunctionModifiers()
    )

    override fun createCommonizer() = FunctionModifiersCommonizer()
}

private fun mockFunctionModifiers(
    isOperator: Boolean = false,
    isInfix: Boolean = false,
    isInline: Boolean = false,
    isSuspend: Boolean = false,
) = CirFunctionModifiers.createInterned(
    isOperator = isOperator,
    isInfix = isInfix,
    isInline = isInline,
    isSuspend = isSuspend,
)
