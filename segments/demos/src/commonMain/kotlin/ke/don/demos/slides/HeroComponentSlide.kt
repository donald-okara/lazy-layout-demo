package ke.don.demos.slides

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import io.github.donald_okara.components.layout.ResizableFocusable
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HeroComponentSlide(
    modifier: Modifier = Modifier
) {
    var focusSize by remember { mutableStateOf<Pair<androidx.compose.ui.unit.Dp, androidx.compose.ui.unit.Dp>?>(null) }

    Column(
        modifier = modifier.fillMaxSize().padding(48.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Column {
            Text(
                "The Adaptive Hero",
                style = MaterialTheme.typography.displaySmallEmphasized,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Components should respond to their container, not just the screen.",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        HorizontallySegmentedScreen(
            modifier = Modifier.weight(1f),
            initialSegments = listOf(
                0.8f to {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        AdaptiveHeroComponent(
                            modifier = Modifier.width(300.dp).height(200.dp),
                            title = "Glancable",
                            onExpand = { focusSize = 300.dp to 200.dp }
                        )
                    }
                },
                1.2f to {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        AdaptiveHeroComponent(
                            modifier = Modifier.fillMaxWidth().height(300.dp).padding(horizontal = 24.dp),
                            title = "Immersive",
                            onExpand = { focusSize = 900.dp to 700.dp }
                        )
                    }
                }
            )
        )
    }

    focusSize?.let { (initialWidth, initialHeight) ->
        ResizableFocusable(
            onDismissRequest = { focusSize = null },
            initialWidth = initialWidth,
            initialHeight = initialHeight
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AdaptiveHeroComponent(
                    title = "Resizable Hero",
                    onExpand = {} 
                )

                IconButton(
                    onClick = { focusSize = null },
                    modifier = Modifier.align(Alignment.TopEnd).padding(16.dp),
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color.Black.copy(alpha = 0.3f),
                        contentColor = Color.White
                    )
                ) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
        }
    }
}

@Composable
fun AdaptiveHeroComponent(
    title: String,
    onExpand: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        val isSmall = maxWidth < 400.dp

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.surfaceVariant,
            tonalElevation = 4.dp
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Background "Image" (Gradient)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Pastel.Pink.color, Pastel.Peach.color)
                            )
                        )
                )

                // Content Overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f))
                            )
                        )
                        .padding(if (isSmall) 16.dp else 32.dp)
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.BottomStart),
                        verticalArrangement = Arrangement.spacedBy(if (isSmall) 4.dp else 8.dp)
                    ) {
                        Text(
                            title,
                            style = if (isSmall) MaterialTheme.typography.titleLarge else MaterialTheme.typography.displaySmall,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        if (!isSmall) {
                            Text(
                                "This component breathes when given more room. It adapts to its immediate container, not just the screen.",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.White.copy(alpha = 0.8f),
                                modifier = Modifier.fillMaxWidth(0.7f)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                ),
                                contentPadding = PaddingValues(horizontal = if (isSmall) 12.dp else 24.dp)
                            ) {
                                Text("Action")
                            }

                            IconButton(
                                onClick = onExpand,
                                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                            ) {
                                Icon(Icons.Default.Fullscreen, contentDescription = "Expand")
                            }
                        }
                    }
                }
            }
        }
    }
}
