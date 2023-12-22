package calculator

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.mariuszgromada.math.mxparser.License

fun main() = application {
    License.iConfirmNonCommercialUse("signature")
    Window(
        onCloseRequest = ::exitApplication,
        title = "My Compose Desktop App"
    ) {
        App()
    }
}
