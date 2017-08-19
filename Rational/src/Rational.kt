class Rational(n: Int, d: Int) {
    init {
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy { gcd(Math.abs(n), Math.abs(d)) }
    val numerator: Int by lazy { n / g }
    val denominator: Int by lazy { d / g }
    operator  fun plus(that: Int): Rational =
        Rational(
                numerator * that.numerator + that.numerator * denominator,
                denominator * that.denominator)
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)
}

operator fun Int.plus(r: Rational): Rational {
    return r + this
}