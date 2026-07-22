package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.don.demos.list_examples.LazyColumnExample
import ke.don.demos.list_examples.LazyColumn_StickyHeader_Example
import ke.don.demos.list_examples.LazyRowExample

@PreviewLightDark
@Composable
fun LazyRowDevicePreview(){
    DevicePreviewComponent {
        LazyRowExample()
    }
}

@PreviewLightDark
@Composable
fun LazyColumnDevicePreview(){
    DevicePreviewComponent {
        LazyColumnExample()
    }
}

@PreviewLightDark
@Composable
fun LazyColumn_StickyHeader_Device_Preview(){
    DevicePreviewComponent {
        LazyColumn_StickyHeader_Example()
    }
}