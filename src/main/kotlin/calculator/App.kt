package calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import calculator.vm.CalculatorViewModel
import calculator.view.ArrayTextField
import calculator.view.Header
import calculator.view.OperandTextField
import calculator.view.OperationDropdown
import calculator.view.button.*

@Composable
fun App() {
    val calculatorViewModel = CalculatorViewModel()

    MaterialTheme {
        val columnScrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(columnScrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Header()
            ArrayTextField(calculatorViewModel)
            OperationDropdown(calculatorViewModel)
            OperandTextField(calculatorViewModel)
            Row {
                CalculateButton(calculatorViewModel)
            }
            Row {
                UndoButton(calculatorViewModel)
                RedoButton(calculatorViewModel)
            }
            Row {
                LoadButton(calculatorViewModel)
                SaveButton(calculatorViewModel)
            }
        }
    }
}
