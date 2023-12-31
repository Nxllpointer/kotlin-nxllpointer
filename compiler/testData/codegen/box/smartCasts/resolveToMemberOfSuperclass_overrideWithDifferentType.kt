// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-51460, KT-51827

open class Base {
    protected open val a: CharSequence
        get() = "Fail: Base"


    fun test(other: Base): String {
        return when (other) {
            is Derived_1 -> other.a.toString()
            is Derived_2 -> other.a.toString()
            else -> "Fail: not Derived"
        }
    }
}

class Derived_1: Base() {
    override val a: String
        get() = "Fail: Derived_1"
}

class Derived_2: Base() {
    override val a: String
        get() = "OK"
}

fun box(): String {
    val x = Derived_2()
    return x.test(x)
}
