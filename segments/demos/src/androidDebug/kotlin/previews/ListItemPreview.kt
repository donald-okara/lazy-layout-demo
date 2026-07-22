package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.don.demos.list_examples.ListItemComponent
import ke.don.demos.list_examples.generatePastelList

@PreviewLightDark
@Composable
fun ListItemDevicePreview(){
    DevicePreviewComponent {
        ListItemComponent(generatePastelList().first())
    }
}