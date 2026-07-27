package previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import ke.don.demos.list_examples.ListItemComponent
import ke.don.demos.list_examples.generatePastelList
import ke.don.demos.slides.CollectionStaggeredGridSlide

@PreviewLightDark
@Composable
fun StaggeredExample(){
    PreviewContent {
        val items = generatePastelList()

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(100.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(items) { item ->
                    ListItemComponent(
                        model = item,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}