package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ke.don.demos.list_examples.LazyColumnExample
import ke.don.demos.list_examples.LazyColumn_StickyHeader_Example
import ke.don.demos.list_examples.LazyRowExample

@PreviewLightDark
@Composable
fun LazyRowPreview(){
    PreviewComponent {
        LazyRowExample()
    }
}

@PreviewLightDark
@Composable
fun LazyColumnPreview(){
    PreviewComponent {
        LazyColumnExample()
    }
}

@PreviewLightDark
@Composable
fun LazyColumn_StickyHeader_Preview(){
    PreviewComponent {
        LazyColumn_StickyHeader_Example()
    }
}