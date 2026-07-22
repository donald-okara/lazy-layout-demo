package ke.don.demos.list_examples

import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlexWrap
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFlexBoxApi::class)
@Composable
fun FlexBoxExample(
    modifier: Modifier = Modifier,
) {
    FlexBox(
        modifier = modifier
            .fillMaxWidth(),
        config = {
            wrap(FlexWrap.Wrap)
            gap(8.dp)
        }
    ) {
        // All boxes have an intrinsic width of 100.dp
        // Some grow to fill any remaining space on the row.
        RoundedBox(
            modifier = Modifier.width(100.dp)
        )
        RoundedBox(
            modifier = Modifier.width(100.dp),
            color = Pastel.Pink.color
        )
        RoundedBox(
            color = Pastel.Mint.color,
            modifier = Modifier
                .width(100.dp)
                .flex { grow(1.0f) }
        )
        RoundedBox(
            color = Pastel.Peach.color,
            modifier = Modifier
                .width(100.dp)
                .flex { grow(1.0f) }
        )
        RoundedBox(
            color = Pastel.Lime.color,
            modifier = Modifier
                .width(100.dp)
                .flex { grow(1.0f) }
        )
    }
}