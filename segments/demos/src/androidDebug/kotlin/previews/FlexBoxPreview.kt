package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.don.demos.list_examples.FlexBoxExample

@PreviewLightDark
@Composable
fun FlexBoxDevicePreview() {
    PreviewContent {
        FlexBoxExample()
    }
}