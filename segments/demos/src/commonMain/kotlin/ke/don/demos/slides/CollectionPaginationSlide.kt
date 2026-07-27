package ke.don.demos.slides

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer

@Composable
fun CollectionPaginationSlide(
    modifier: Modifier = Modifier
) {
    var showCode by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Pagination",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ElevatedCard(
                    modifier = Modifier.weight(1f).padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Endless Scroll",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "Best for focus, mobile users, and engagement (e.g., Videos, Pinterest).",
                            textAlign = TextAlign.Center
                        )
                    }
                }

                ElevatedCard(
                    modifier = Modifier.weight(1f).padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Paging Bars",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "Better for multi-pane screens and fitting more content in sections.",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {}) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                            }
                            Text("Page 1 of 10")
                            IconButton(onClick = {}) {
                                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }

        IconButton(
            onClick = { showCode = true },
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        ) {
            Icon(Icons.Default.Code, contentDescription = "Show Code")
        }
    }

    if (showCode) {
        FocusKotlinViewer(
            onDismiss = { showCode = false },
            darkTheme = true,
            toggleTheme = {}
        ) {
            """
            // Conceptual Paging Bar
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onPreviousPage) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
                Text("Page ${'$'}currentPage of ${'$'}totalPages")
                IconButton(onClick = onNextPage) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, null)
                }
            }
            """.trimIndent()
        }
    }
}
