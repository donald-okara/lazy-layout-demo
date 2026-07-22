package ke.don.gallery.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.draggable.DraggableBox
import io.github.donald_okara.components.layout.Focusable as FocusableUI
import io.github.donald_okara.components.layout.LazyScatterFlow
import ke.don.gallery.domain.ComponentGalleryBuilder
import ke.don.gallery.domain.ComponentType
import ke.don.gallery.domain.Focusable

fun ComponentGalleryBuilder.layouts() {
    component(
        label = "Lazy Scatter Flow",
        description = scatterDescription,
        type = ComponentType.Layout,
        rendered = {
            LazyScatterFlow(
                items = List(3) { "Item $it" },
                itemsPerRow = 2,
                modifier = Modifier.fillMaxSize()
            ) { index, item ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = index.toString(), color = MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
        },
        dos = scatterDos,
        donts = scatterDonts
    )

    component(
        label = "Draggable Box",
        description = draggableDescription,
        type = ComponentType.Layout,
        rendered = {
            Box(modifier = Modifier.fillMaxSize()) {
                DraggableBox(
                    initialWidth = 150.dp,
                    initialHeight = 150.dp
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Drag me or the handle!", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        },
        focusable = Focusable(
            path = "components.draggable.DraggableBox",
            rendered = draggableFocusable()
        ),
        dos = draggableDos,
        donts = draggableDonts
    )
}

private fun draggableFocusable(): @Composable (onDismiss: () -> Unit) -> Unit = { onDismiss ->
    FocusableUI(onDismissRequest = onDismiss) {
        Box(modifier = Modifier.fillMaxSize()) {
            DraggableBox(
                initialWidth = 300.dp,
                initialHeight = 300.dp,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Focus Mode: Large Draggable Box")
                }
            }
        }
    }
}

val scatterDescription = "The Lazy Scatter Flow layout arranges children in a flow-like structure with configurable row density. It is ideal for showcasing varied content like badges, tags, or small icons in a flexible, non-rigid layout." +
        "\n\n" +
        "Features:" +
        "\n- Deterministic flow-based placement with configurable spacing" +
        "\n- Configurable items per row to control density"

val scatterDos = listOf(
    "Use for collections of items that don't require strict alignment (e.g., skill tags, logo clouds)",
    "Vary the sizes or shapes of child elements to enhance the 'scattered' effect",
    "Keep the number of items per row low to allow for more visible scattering",
    "Use for decorative elements that should feel organic and less structured"
)

val scatterDonts = listOf(
    "Avoid using for data-heavy lists where quick scanning and readability are critical",
    "Don't use for primary navigation elements that require a predictable layout",
    "Avoid overcrowding the flow; ensure there is enough space between items to appreciate the scattering"
)

val draggableDescription = "A flexible container that can be moved and resized by the user. It is useful for creating customizable dashboards, floating windows, or interactive canvas-like interfaces." +
        "\n\n" +
        "Features:" +
        "\n- Drag anywhere on the box to move it" +
        "\n- Drag the bottom-right handle to resize" +
        "\n- Configurable minimum dimensions"

val draggableDos = listOf(
    "Use for floating tools or inspectors that the user might want to reposition",
    "Provide clear visual cues that the box is interactive",
    "Set reasonable minimum sizes to prevent the content from becoming unreadable",
    "Use in layouts where users benefit from customizing their workspace"
)

val draggableDonts = listOf(
    "Don't use for primary content that should have a fixed position in the UI",
    "Avoid placing too many draggable elements on the screen at once to prevent clutter",
    "Don't forget to handle edge cases like dragging elements off-screen"
)

