package ke.don.demos.slides

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalLayoutApi::class)
@Composable
fun FlowRowSlide(
    modifier: Modifier = Modifier
) {
    var showCode by remember { mutableStateOf(false) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(32.dp),
        initialSegments = listOf(
            1.5f to {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        repeat(12) { index ->
                            RoundedBox(
                                modifier = Modifier.width(if (index % 3 == 0) 140.dp else 90.dp),
                                height = 50,
                                color = Pastel.Mint.color,
                                title = "Item $index"
                            )
                        }
                    }

                    IconButton(
                        onClick = { showCode = true },
                        modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
                    ) {
                        Icon(Icons.Default.Code, contentDescription = "Show Code")
                    }
                }
            },
            1f to {
                Column(
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "FlowRow",
                        style = MaterialTheme.typography.displaySmallEmphasized,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Items wrap naturally to the next line when they exceed the container width. Perfect for tags and chips",
                        style = MaterialTheme.typography.bodyLargeEmphasized
                    )
                }
            }
        )
    )

    if (showCode) {
        FocusKotlinViewer(
            onDismiss = { showCode = false },
            darkTheme = true,
            toggleTheme = {}
        ) {
            """
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items.forEach { item ->
                    ItemComponent(item)
                }
            }
            """.trimIndent()
        }
    }
}
