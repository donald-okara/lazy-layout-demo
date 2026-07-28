package ke.don.demos.slides

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ConclusionSlide(
    modifier: Modifier = Modifier
) {
    val summaryPoints = listOf(
        "Adaptive Components (FlowRow, Marquee, FlexBox, Grid)",
        "Hero Components & Adaptive Layouts",
        "Dynamic Collections (Grids, Staggered Grids, Pagination)",
        "Navigation 3 Strategies (List-Detail, Supporting Pane)"
    )

    var visiblePoints by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        for (i in 1..summaryPoints.size) {
            delay(500)
            visiblePoints = i
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Column {
            Text(
                "Key Takeaways",
                style = MaterialTheme.typography.displayMediumEmphasized,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                "Summarizing our journey into adaptive Compose layouts.",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            summaryPoints.forEachIndexed { index, point ->
                AnimatedVisibility(
                    visible = visiblePoints > index,
                    enter = fadeIn() + expandVertically()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = point,
                            style = MaterialTheme.typography.headlineSmallEmphasized
                        )
                    }
                }
            }
        }
    }
}
