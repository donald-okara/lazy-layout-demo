package ke.don.demos.slides

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.devices.DeviceCatalog
import io.github.donald_okara.components.devices.DeviceFrame
import io.github.donald_okara.components.devices.DeviceOrientation
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import ke.don.demos.list_examples.ContentLines
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NavigationStrategiesSlide(
    modifier: Modifier = Modifier,
) {
    var focusCode by remember { mutableStateOf<String?>(null) }
    var isDarkTheme by remember { mutableStateOf(value = true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(48.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Column {
            Text(
                "Navigation 3 Strategies",
                style = MaterialTheme.typography.displaySmallEmphasized,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Scaling architecture for adaptive layouts using Pixel Fold",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            StrategySegment(
                title = "List-Detail",
                codeSnippet = LIST_DETAIL_CODE,
                onViewCode = { focusCode = it },
                modifier = Modifier.weight(1f)
            ) {
                DeviceFrame(
                    spec = DeviceCatalog.PixelFold.copy(orientation = DeviceOrientation.HALF_OPENED),
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    HorizontallySegmentedScreen(
                        modifier = Modifier.fillMaxSize(),
                        enableDrag = false,
                        initialSegments = listOf(
                            1f to {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    repeat(5) {
                                        RoundedBox(
                                            modifier = Modifier.fillMaxWidth().height(40.dp),
                                            color = Pastel.entries[it % Pastel.entries.size].color,
                                            title = "Item $it"
                                        )
                                    }
                                }
                            },
                            1f to {
                                Box(
                                    modifier = Modifier.fillMaxSize().padding(8.dp).background(
                                        MaterialTheme.colorScheme.surfaceVariant,
                                        RoundedCornerShape(8.dp)
                                    ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("Detail View", style = MaterialTheme.typography.titleMedium)
                                        Spacer(modifier = Modifier.height(8.dp))
                                        ContentLines()
                                    }
                                }
                            }
                        )
                    )
                }
            }

            StrategySegment(
                title = "Supporting Pane",
                codeSnippet = SUPPORTING_PANE_CODE,
                onViewCode = { focusCode = it },
                modifier = Modifier.weight(1f)
            ) {
                DeviceFrame(
                    spec = DeviceCatalog.PixelFold.copy(orientation = DeviceOrientation.HALF_OPENED),
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Main Content
                        Column(
                            modifier = Modifier.fillMaxSize().padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("Main Document", style = MaterialTheme.typography.headlineSmall)
                            ContentLines()
                            ContentLines()
                        }

                        // Supporting Pane (Simulation)
                        Surface(
                            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight().fillMaxWidth(0.35f),
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            tonalElevation = 8.dp
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Metadata", style = MaterialTheme.typography.titleSmall)
                                Spacer(modifier = Modifier.height(8.dp))
                                repeat(3) {
                                    RoundedBox(
                                        modifier = Modifier.fillMaxWidth().height(30.dp).padding(vertical = 2.dp),
                                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.1f),
                                        title = "Tag $it"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    focusCode?.let { code ->
        FocusKotlinViewer(
            title = "Navigation 3 Strategy",
            onDismiss = { focusCode = null },
            darkTheme = isDarkTheme,
            toggleTheme = { isDarkTheme = !isDarkTheme },
            code = { code }
        )
    }
}

@Composable
private fun StrategySegment(
    title: String,
    codeSnippet: String,
    onViewCode: (String) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            IconButton(onClick = { onViewCode(codeSnippet) }) {
                Icon(Icons.Default.Code, contentDescription = "View Code")
            }
        }
        
        Box(
            modifier = Modifier
                .weight(1f)
                .background(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp),
            content = content
        )
    }
}
