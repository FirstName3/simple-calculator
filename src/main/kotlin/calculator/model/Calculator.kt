package calculator.model

import org.mariuszgromada.math.mxparser.Expression
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

//Can throw infinite or NaN
fun calculate(input: String): String {
    val result = BigDecimal(Expression(input).calculate())
        .round(MathContext(10, RoundingMode.HALF_UP))
        .setScale(10, RoundingMode.HALF_UP)
        .stripTrailingZeros()
    return result.toPlainString()
}
