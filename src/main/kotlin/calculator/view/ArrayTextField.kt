package calculator.view

import androidx.compose.runtime.Composable
import calculator.component.MutableTextField
import calculator.vm.CalculatorViewModel

@Composable
fun ArrayTextField(
    calculatorViewModel: CalculatorViewModel,
) {
    MutableTextField(
        label = "Array",
        value = calculatorViewModel.array,
        onValueChange = calculatorViewModel::onArrayChange,
    )
}
