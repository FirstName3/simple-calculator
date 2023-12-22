package calculator.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PaddedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.padding(top = 3.dp, start = 10.dp, end = 10.dp, bottom = 3.dp),
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(text)
    }
}
