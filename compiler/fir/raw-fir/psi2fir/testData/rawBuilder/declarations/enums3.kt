class C {
    init {
        enum class Planet(val m: Double, internal val r: Double) {
            MERCURY(1.0, 2.0) {
                override fun sayHello() {
                    println("Hello!!!")
                }
            },
            VENERA(3.0, 4.0) {
                override fun sayHello() {
                    println("Ola!!!")
                }
            },
            EARTH(5.0, 6.0) {
                override fun sayHello() {
                    println("Privet!!!")
                }
            };

            val g: Double = G * m / (r * r)

            abstract fun sayHello()

            companion object {
                const val G = 6.67e-11
            }
        }
    }
}
