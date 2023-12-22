package calculator.view.button

import androidx.compose.runtime.Composable
import calculator.component.PaddedButton
import calculator.vm.CalculatorViewModel

@Composable
fun UndoButton(
    calculatorViewModel: CalculatorViewModel,
) {
    PaddedButton(
        "Undo",
        calculatorViewModel::undo
    )
}
