package calculator.view.button

import androidx.compose.runtime.Composable
import calculator.component.PaddedButton
import calculator.vm.CalculatorViewModel

@Composable
fun RedoButton(
    calculatorViewModel: CalculatorViewModel,
) {
    PaddedButton(
        "Redo",
        calculatorViewModel::redo
    )
}
