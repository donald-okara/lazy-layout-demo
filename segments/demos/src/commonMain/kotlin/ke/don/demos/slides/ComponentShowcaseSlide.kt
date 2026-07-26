package ke.don.demos.slides

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import ke.don.demos.list_examples.FlexBoxExample
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalLayoutApi::class, ExperimentalFlexBoxApi::class)
@Composable
fun ComponentShowcaseSlide(
    modifier: Modifier = Modifier
) {
    var selectedCode by remember { mutableStateOf<String?>(null) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(32.dp),
        initialSegments = listOf(
            1f to {
                ShowcaseSegment(
                    title = "FlowRow",
                    onShowCode = {
                        selectedCode =
                            """
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(8) { index ->
                            RoundedBox(
                                modifier = Modifier
                                    .width(if (index % 2 == 0) 80.dp else 120.dp),
                                height = 40,
                                color = Pastel.Mint.color
                            )
                        }
                    }
                            """.trimIndent()
                    }
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(8) { index ->
                            RoundedBox(
                                modifier = Modifier.width(if (index % 2 == 0) 80.dp else 120.dp),
                                height = 40,
                                color = Pastel.Mint.color
                            )
                        }
                    }
                }
            },
            1f to {
                ShowcaseSegment(
                    title = "FlexBox",
                    onShowCode = {
                        selectedCode =
                            """
                    
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
                            """.trimIndent()
                    }
                ) {
                    FlexBoxExample()
                }
            },
            1f to {
                ShowcaseSegment(
                    title = "Marquee",
                    onShowCode = {
                        selectedCode =
                            """
                         Text(
                            text = "Adaptive UI is not just about screens, it's about making every single component resilient to container changes.",
                            modifier = Modifier.padding(16.dp).basicMarquee(),
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 1
                        )
                            """.trimIndent()
                    }
                ) {
                    RoundedBox(
                        modifier = Modifier.fillMaxWidth(),
                        height = 100,
                        color = Pastel.Yellow.color
                    ) {
                        Text(
                            "Adaptive UI is not just about screens, it's about making every single component resilient to container changes.",
                            modifier = Modifier.padding(16.dp).basicMarquee(),
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 1
                        )
                    }
                }
            }
        )
    )

    if (selectedCode != null) {
        FocusKotlinViewer(
            onDismiss = { selectedCode = null },
            darkTheme = true,
            toggleTheme = {}
        ) {
            selectedCode!!
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun ShowcaseSegment(
    title: String,
    onShowCode: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleLargeEmphasized,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onShowCode) {
                Icon(Icons.Default.Code, contentDescription = "Show Code")
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
