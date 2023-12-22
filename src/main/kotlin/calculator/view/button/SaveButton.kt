package calculator.view.button

import androidx.compose.runtime.Composable
import calculator.component.PaddedButton
import calculator.vm.CalculatorViewModel

@Composable
fun SaveButton(
    calculatorViewModel: CalculatorViewModel,
) {
    PaddedButton(
        "Save",
        calculatorViewModel::save
    )
}
