package ke.don.demos.list_examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItemComponent(
    model: ListModel,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable (BoxScope.() -> Unit)? = null
) {
    RoundedBox(
        modifier = modifier.aspectRatio(model.aspectRatio),
        title = model.id.toString(),
        color = model.color,
        height = null,
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun ContentLines(
    modifier: Modifier = Modifier,
    color: Color = Color.Black.copy(alpha = 0.2f)
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(6.dp)
                .background(color, RoundedCornerShape(3.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(6.dp)
                .background(color, RoundedCornerShape(3.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(6.dp)
                .background(color, RoundedCornerShape(3.dp))
        )
    }
}

@Composable
fun RoundedBox(
    modifier: Modifier = Modifier,
    title: String = "",
    height: Int? = 100,
    color: Color = Pastel.Lavender.color,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable (BoxScope.() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color)
            .border(
                width = 2.dp,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            .then(if (height != null) Modifier.height(height.dp) else Modifier)
            .then(modifier),
        contentAlignment = contentAlignment
    ) {
        if (content != null) {
            content()
        } else {
            Text(title, fontSize = 24.sp, color = Color.Black)
        }
    }
}
