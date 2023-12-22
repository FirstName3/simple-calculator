package calculator.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import calculator.model.Operation
import calculator.model.UndoRedoStack
import calculator.model.calculate
import java.io.File

class CalculatorViewModel {

    var array by mutableStateOf("8")
    private val undoRedoStack by mutableStateOf(UndoRedoStack<String>())

    var operation by mutableStateOf(Operation.ADDITION)
    var operand by mutableStateOf("2")

    companion object {
        private val ARRAY_REGEXP = "-?\\d*(\\.\\d*)?(?:,\\s*-?\\d*(\\.\\d*)?)*\\s*".toRegex()
        private val OPERAND_REGEXP = "-?\\d*(\\.\\d*)?".toRegex()
    }

    fun onArrayChange(newArray: String) {
        if (newArray.matches(ARRAY_REGEXP)) {
            undoRedoStack.push(array)
            array = newArray
        }
    }

    fun onOperationChange(newOperationIndex: Int) {
        operation = Operation.fromIndex(newOperationIndex)
        if (operation.isUnary()) {
            operand = ""
        }
    }

    fun onOperandChange(newOperand: String) {
        if (newOperand.matches(OPERAND_REGEXP)) {
            operand = newOperand
        }
    }

    fun isOperandVisible(): Boolean {
        return operation.isBinary()
    }

    fun calculate() {
        if (operation.isOperandArray) {
            val expression = renderExpression(array)
            val result = calculate(expression)
            onArrayChange(result)
            return
        }

        val numbers = getNumbers()
        var result = ""
        numbers.forEach { number ->
            if (result.isNotBlank()) {
                result += ", "
            }
            val expression = renderExpression(number)
            result += calculate(expression)
        }
        onArrayChange(result)
    }

    /**
     * Casting to Long to double-check that we're working with decimal numbers
     */
    private fun getNumbers(): Collection<String> {
        return array.replace(" ", "")
            .split(",")
            .filter { it.isNotBlank() }
    }

    private fun renderExpression(x: String): String {
        return if (operation.isBinary()) {
            operation.render(x, operand)
        } else {
            operation.render(x)
        }
    }

    fun undo() {
        array = undoRedoStack.undo(array)
    }

    fun redo() {
        array = undoRedoStack.redo(array)
    }

    fun load() {
        val lines = File("load.txt").readLines()
        onArrayChange(lines[0])
        onOperandChange(lines[1])
    }

    fun save() {
        File("save.txt").writeText("$array\n$operand")
    }
}
