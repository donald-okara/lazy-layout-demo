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
import ke.don.demos.list_examples.FlexBoxExample
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalLayoutApi::class)
@Composable
fun FlexBoxSlide(
    modifier: Modifier = Modifier
) {
    var showCode by remember { mutableStateOf(false) }
    var isCodeDarkTheme by remember { mutableStateOf(true) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(32.dp),
        initialSegments = listOf(
            1.5f to {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    FlexBoxExample(modifier = Modifier.padding(16.dp))

                    NewBadge(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                    )

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
                        "FlexBox",
                        style = MaterialTheme.typography.displaySmallEmphasized,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "An advanced version of FlowRow that supports 'grow' and 'shrink' behaviors. Items can expand to fill remaining space in a row.",
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
            FlexBox(
                config = {
                    wrap(FlexWrap.Wrap)
                    gap(8.dp)
                }
            ) {
                RoundedBox(
                    modifier = Modifier
                        .width(100.dp)
                        .flex { grow(1.0f) }
                )
            }
            """.trimIndent()
        }
    }
}
