// IGNORE_PARENTING_CHECK

class Inv<E>
class Out<out T>
class OutPair<out Final, out Y>
class In<in Z>

class Final
open class Open

@JvmSuppressWildcards(true)
fun deepOpen(x: Out<Out<Out<Open>>>) {}

@JvmSuppressWildcards(false)
fun bar(): Out<Open> = null!!

fun simpleOut(x: Out<@JvmWildcard Final>) {}
fun simpleIn(x: In<@JvmWildcard Any?>) {}

fun falseTrueFalse(): @JvmSuppressWildcards(false) OutPair<Final, @JvmSuppressWildcards OutPair<Out<Final>, Out<@JvmSuppressWildcards(false) Final>>> = null!!
fun combination(): @JvmSuppressWildcards OutPair<Open, @JvmWildcard OutPair<Open, @JvmWildcard Out<Open>>> = null!!

@JvmSuppressWildcards(false)
fun foo(x: Boolean, y: Out<Int>): Int = 1

@JvmSuppressWildcards(true)
fun bar(x: Boolean, y: In<Long>, z: @JvmSuppressWildcards(false) Long): Int = 1

@JvmSuppressWildcards(true)
fun foo2(): Out<T>

@JvmSuppressWildcards(true)
fun foo3(): In<Open>
// COMPILATION_ERRORS