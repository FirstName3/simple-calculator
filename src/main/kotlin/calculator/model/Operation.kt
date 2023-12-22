package calculator.model

enum class Operation(
    private val formula: String,
    val isOperandArray: Boolean = false,
) {
    ADDITION("x + y"),
    DIFFERENCE("x - y"),
    MULTIPLICATION("x * y"),
    DIVISION("x / y"),
    DEGREE_2("x^2"),
    DEGREE("x^y"),
    SQUARE_2("root(x, 2)"),
    SQUARE("root(x, y)"),
    LOG("log(x, y)"),
    FACT("fact(x)"),
    MEDIAN("med(x)", true),
    STANDARD_DEVIATION("std(x)", true);

    fun isBinary() = formula.contains("y")

    fun isUnary() = !isBinary()

    fun render(x: String, y: String? = null): String {
        var renderingFormula = formula
        renderingFormula = renderingFormula.replace("x", x)
        if (isBinary()) {
            renderingFormula = renderingFormula.replace("y", y!!)
        }
        return renderingFormula
    }

    companion object {

        fun fromIndex(index: Int): Operation {
            return Operation.entries[index]
        }
    }
}
