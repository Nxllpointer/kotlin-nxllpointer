// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: UNSUPPORTED_JS_INTEROP
// EXPECTED_REACHABLE_NODES: 1412
//FILE: nativeClassAsReifiedTypeArgument.kt

var global = ""

inline fun <reified T : Any> log(x: T) {
    global += T::class.js.name + ": " + x
}

external class C {
    override fun toString() = definedExternally
}

fun box(): String {
    log(C())
    if (global != "C: C instance") return "fail: $global"
    return "OK"
}

//FILE: nativeClassAsReifiedTypeArgument.js

function C() {
}
C.prototype.toString = function() {
    return "C instance"
}