// STRIP_METADATA
// TODO: Re-enable metadata generation
import kotlinx.kapt.*

class Test {
    @KaptIgnored
    fun ignoredFun() {}

    @KaptIgnored @get:KaptIgnored
    const val ignoredProperty: String = ""

    fun nonIgnoredFun() {}

    val nonIgnoredProperty: String = ""
}
