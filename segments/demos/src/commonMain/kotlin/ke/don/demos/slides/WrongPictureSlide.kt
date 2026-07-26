package ke.don.demos.slides

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.UnfoldLess
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.devices.*
import io.github.donald_okara.components.layout.Focusable
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun WrongPictureSlide(
    modifier: Modifier = Modifier
) {
    var showFocusable by remember { mutableStateOf(false) }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(48.dp),
        initialSegments = listOf(
            1f to {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    // Small folded phone representation
                    DeviceFrame(
                        spec = DeviceCatalog.PixelFold.copy(orientation = DeviceOrientation.PORTRAIT),
                        modifier = Modifier.fillMaxHeight(0.6f)
                    ) {
                        PhoneContent(isFolded = true)
                    }

                    // Expand button overlaid
                    IconButton(
                        onClick = { showFocusable = true },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 24.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Icon(Icons.Default.Expand, contentDescription = "Expand")
                    }
                }
            },
            1f to {
                Column(
                    modifier = Modifier.fillMaxSize().padding(start = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "What is wrong with this picture?",
                        style = MaterialTheme.typography.headlineLargeEmphasized,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    )

    if (showFocusable) {
        Focusable(onDismissRequest = { showFocusable = false }) {
            var isFolded by remember { mutableStateOf(true) }

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    DeviceFrame(
                        spec = DeviceCatalog.PixelFold.copy(
                            orientation = if (isFolded) DeviceOrientation.PORTRAIT else DeviceOrientation.HALF_OPENED
                        ),
                        modifier = Modifier.fillMaxHeight(0.8f)
                    ) {
                        PhoneContent(isFolded = isFolded)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { isFolded = !isFolded },
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Icon(
                            if (isFolded) Icons.Default.UnfoldMore else Icons.Default.UnfoldLess,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(if (isFolded) "Unfold Device" else "Fold Device")
                    }
                }

                IconButton(
                    onClick = { showFocusable = false },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(24.dp)
                ) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
        }
    }
}

@Composable
private fun MockLine(
    widthPercent: Float,
    modifier: Modifier = Modifier,
    color: Color = Color.Black.copy(alpha = 0.2f)
) {
    Box(
        modifier = modifier
            .fillMaxWidth(widthPercent)
            .height(8.dp)
            .clip(MaterialTheme.shapes.extraSmall)
            .background(color)
    )
}

@Composable
private fun PhoneContent(isFolded: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        // Hero Card
        RoundedBox(
            modifier = Modifier.fillMaxWidth().height(if (isFolded) 120.dp else 180.dp),
            color = Pastel.Pink.color
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MockLine(0.4f, color = Color.Black.copy(alpha = 0.4f))
                Spacer(modifier = Modifier.height(4.dp))
                MockLine(0.9f)
                MockLine(0.7f)
                MockLine(0.8f)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Filter Row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(6) {
                RoundedBox(
                    modifier = Modifier.width(80.dp),
                    color = Pastel.Mint.color,
                    height = 32
                ) {
                    MockLine(0.6f, modifier = Modifier.align(Alignment.Center))
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // List of Cards
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(10) { index ->
                RoundedBox(
                    modifier = Modifier.fillMaxWidth().height(80.dp),
                    color = Pastel.Lavender.color
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Thumbnail mock
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(MaterialTheme.shapes.small)
                                .background(Color.Black.copy(alpha = 0.1f))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            MockLine(0.4f, color = Color.Black.copy(alpha = 0.3f))
                            MockLine(0.9f)
                        }
                    }
                }
            }
        }
    }
}
