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
import io.github.donald_okara.components.NewBadge
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalGridApi::class)
@Composable
fun GridSlide(
    modifier: Modifier = Modifier
) {
    var showCode by remember { mutableStateOf(false) }
    var showWindowSizeCode by remember { mutableStateOf(false) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(32.dp),
        initialSegments = listOf(
            1.5f to {
                BoxWithConstraints(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    val width = maxWidth
                    val cols = when {
                        width < 240.dp -> 1
                        width < 420.dp -> 2
                        width < 720.dp -> 3
                        else -> 4
                    }
                    val isLarge = width >= 420.dp

                    NewBadge(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                    )

                    Grid(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        config = {
                            repeat(cols) { column(1.fr) }
                            repeat(4) { row(GridTrackSize.Auto) }
                            gap(12.dp)
                        }
                    ) {
                        repeat(6) { index ->
                            val colSpan = if (index == 0 && isLarge) 2 else 1
                            val rowSpan = if (index == 1 && isLarge) 2 else 1
                            
                            RoundedBox(
                                modifier = Modifier
                                    .gridItem(
                                        columnSpan = colSpan.coerceAtMost(cols),
                                        rowSpan = rowSpan
                                    )
                                    .fillMaxWidth(),
                                height = if (rowSpan > 1) 172 else 80,
                                color = when(index % 4) {
                                    0 -> Pastel.Pink.color
                                    1 -> Pastel.Mint.color
                                    2 -> Pastel.Lavender.color
                                    else -> Pastel.Peach.color
                                },
                                title = (index + 1).toString()
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
                        "Grid",
                        style = MaterialTheme.typography.displaySmallEmphasized,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "The experimental Grid API provides a way to define responsive row and column structures that adapt programmatically to the container's constraints.",
                        style = MaterialTheme.typography.bodyLargeEmphasized
                    )

                    Spacer(modifier = Modifier.height(48.dp))
                    
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                    
                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        IconButton(
                            onClick = { showWindowSizeCode = true },
                            colors = IconButtonDefaults.filledIconButtonColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                            )
                        ) {
                            Icon(Icons.Default.Code, contentDescription = "Window Size API")
                        }
                        
                        Text(
                            "Use Window Size API V2 to determine screen size (including L and XL support) for global layout decisions.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
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
            val adaptiveInfo = currentWindowAdaptiveInfoV2()
            val windowSizeClass = adaptiveInfo.windowSizeClass
            
            Grid(
                config = {
                    val cols = when(windowSizeClass.windowWidthSizeClass) {
                        WindowWidthSizeClass.COMPACT -> 1
                        WindowWidthSizeClass.MEDIUM -> 2
                        WindowWidthSizeClass.EXPANDED -> 3
                        WindowWidthSizeClass.LARGE -> 4
                        WindowWidthSizeClass.EXTRA_LARGE -> 5
                        else -> 2
                    }
                    repeat(cols) { column(1.fr) }
                    repeat(4) { row(GridTrackSize.Auto) }
                    gap(12.dp)
                }
            ) {
                Item(
                    modifier = Modifier.gridItem(
                        columnSpan = if (windowSizeClass.windowWidthSizeClass != WindowWidthSizeClass.COMPACT) 2 else 1
                    )
                )
            }
            """.trimIndent()
        }
    }

    if (showWindowSizeCode) {
        FocusKotlinViewer(
            onDismiss = { showWindowSizeCode = false },
            darkTheme = true,
            toggleTheme = {}
        ) {
            """
            // Adaptive Window Size API V2
            // Supports Large (L) and Extra Large (XL) classes
            val adaptiveInfo = currentWindowAdaptiveInfoV2()
            val windowSizeClass = adaptiveInfo.windowSizeClass
            
            when (windowSizeClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> { /* Phone */ }
                WindowWidthSizeClass.MEDIUM -> { /* Foldable / Small Tablet */ }
                WindowWidthSizeClass.EXPANDED -> { /* Tablet */ }
                WindowWidthSizeClass.LARGE -> { /* Large Tablet / Desktop */ }
                WindowWidthSizeClass.EXTRA_LARGE -> { /* Ultra-wide / 4K Desktop */ }
            }
            """.trimIndent()
        }
    }
}
