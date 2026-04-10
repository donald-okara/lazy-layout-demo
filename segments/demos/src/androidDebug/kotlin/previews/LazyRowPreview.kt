package previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import io.github.donald_okara.components.devices.DeviceCatalog
import io.github.donald_okara.components.devices.DeviceFrame
import io.github.donald_okara.components.devices.deviceSafePadding
import ke.don.demos.list_examples.LazyRowExample

@PreviewLightDark
@Composable
fun LazyRowPreview(){
    PreviewComponent {
        LazyRowExample()
    }
}