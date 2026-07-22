package ke.don.demos.list_examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
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
) {
    RoundedBox(
        modifier = modifier.aspectRatio(model.aspectRatio),
        title = model.id.toString(),
        color = model.color
    )
}

@Composable
fun RoundedBox(
    modifier: Modifier = Modifier,
    title: String = "",
    color: Color = Pastel.Lavender.color
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
            .then(modifier)
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(title, fontSize = 24.sp, color = Color.Black)
    }
}