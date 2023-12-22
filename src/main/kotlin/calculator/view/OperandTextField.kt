package calculator.view

import androidx.compose.runtime.Composable
import calculator.component.MutableTextField
import calculator.vm.CalculatorViewModel

@Composable
fun OperandTextField(
    calculatorViewModel: CalculatorViewModel
) {
    if (calculatorViewModel.isOperandVisible()) {
        MutableTextField(
            label = "Operand",
            value = calculatorViewModel.operand,
            onValueChange = calculatorViewModel::onOperandChange,
        )
    }
}
