// TARGET_BACKEND: JVM
// ISSUE: KT-51194
// DIAGNOSTICS: +CONFLICTING_INHERITED_MEMBERS_WARNING
// IGNORE_BACKEND_K2: JVM_IR, JS_IR
// FIR status: FIR correctly reports CONFLICTING_INHERITED_MEMBERS, so this test should not pass design
//   For details see related issue

// MODULE: coreLib_1
// FILE: Base.java
public interface Base {
    Object foo();
}

// MODULE: lib(coreLib_1)
// FILE: Derived.kt
abstract class Derived : Base {
    override fun foo(): Any? = null
}

// MODULE: coreLib_2
// FILE: Base.java
public interface Base {
    <T> T foo();
}

// MODULE: main(coreLib_2, lib)
// FILE: main.kt
<!CONFLICTING_INHERITED_MEMBERS_WARNING!>class Implementation<!> : Derived()

fun box() = "OK"
