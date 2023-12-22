package calculator.component

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp

@Composable
fun MutableTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    modifier: Modifier = Modifier.padding(10.dp),
) {
    TextField(
        readOnly = false,
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.focusable().onKeyEvent(onKeyEvent),
    )
}
