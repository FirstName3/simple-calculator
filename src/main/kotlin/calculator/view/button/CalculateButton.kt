package calculator.view.button

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import calculator.component.PaddedButton
import calculator.vm.CalculatorViewModel

@Composable
fun CalculateButton(
    calculatorViewModel: CalculatorViewModel,
) {
    PaddedButton(
        "Calculate",
        calculatorViewModel::calculate,
        Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 3.dp)
    )
}
