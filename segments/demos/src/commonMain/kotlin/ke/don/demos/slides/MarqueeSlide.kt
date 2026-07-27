package ke.don.demos.slides

import androidx.compose.foundation.basicMarquee
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

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MarqueeSlide(
    modifier: Modifier = Modifier
) {
    var showCode by remember { mutableStateOf(false) }
    var isCodeDarkTheme by remember { mutableStateOf(true) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(32.dp),
        initialSegments = listOf(
            1.5f to {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(32.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        RoundedBox(
                            modifier = Modifier.fillMaxWidth(),
                            height = 80,
                            color = Pastel.Yellow.color
                        ) {
                            Text(
                                "This is a very long text that would normally be truncated with ellipses, but thanks to basicMarquee it scrolls!",
                                modifier = Modifier.padding(horizontal = 16.dp).basicMarquee(),
                                style = MaterialTheme.typography.titleLarge,
                                maxLines = 1
                            )
                        }

                        RoundedBox(
                            modifier = Modifier.width(200.dp),
                            height = 60,
                            color = Pastel.Pink.color
                        ) {
                            Text(
                                "Short marquee",
                                modifier = Modifier.padding(horizontal = 12.dp).basicMarquee(),
                                style = MaterialTheme.typography.bodyLarge,
                                maxLines = 1
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
                        "Marquee",
                        style = MaterialTheme.typography.displaySmallEmphasized,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "The basicMarquee modifier allows content to scroll horizontally when it's too wide for its container. Essential for maintaining accessibility without compromising layout.",
                        style = MaterialTheme.typography.bodyLargeEmphasized
                    )
                }
            }
        )
    )

    if (showCode) {
        FocusKotlinViewer(
            onDismiss = { showCode = false },
            darkTheme = isCodeDarkTheme,
            toggleTheme = { isCodeDarkTheme = !isCodeDarkTheme }
        ) {
            """
            Text(
                text = "Very long scrolling text...",
                modifier = Modifier.basicMarquee(),
                maxLines = 1
            )
            """.trimIndent()
        }
    }
}
