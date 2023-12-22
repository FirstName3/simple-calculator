package calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import calculator.model.Operation
import calculator.vm.CalculatorViewModel

@Composable
fun OperationDropdown(
    calculatorViewModel: CalculatorViewModel,
) {
    var expanded by remember { mutableStateOf(false) }

    val background = TextFieldDefaults.textFieldColors().backgroundColor(enabled = true).value
    Box(modifier = Modifier.background(background)) {
        Text(
            calculatorViewModel.operation.toString(),
            modifier = Modifier
                .clickable { expanded = true }
                .padding(16.dp)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Operation.entries.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    calculatorViewModel.onOperationChange(index)
                    expanded = false
                }) {
                    Text(text = item.toString())
                }
            }
        }
    }
}