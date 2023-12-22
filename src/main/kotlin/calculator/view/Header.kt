package calculator.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Text(
        text = "I'm a simple calculator",
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(20.dp),
    )
}
