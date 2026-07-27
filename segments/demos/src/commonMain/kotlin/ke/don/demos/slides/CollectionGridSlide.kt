package ke.don.demos.slides

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.guides.code_viewer.FocusKotlinViewer
import ke.don.demos.list_examples.ContentLines
import ke.don.demos.list_examples.ListItemComponent
import ke.don.demos.list_examples.generatePastelList

@Composable
fun CollectionGridSlide(
    modifier: Modifier = Modifier
) {
    val items = generatePastelList()
    var showCode by remember { mutableStateOf(false) }
    var isCodeDarkTheme by remember { mutableStateOf(true) }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                "LazyVerticalGrid",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Leverage the available space by using multiple columns.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 120.dp),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) {
                    ListItemComponent(
                        model = it,
                        contentAlignment = Alignment.BottomStart,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                        content = {
                            ContentLines()
                        }
                    )
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
            darkTheme = isCodeDarkTheme,
            toggleTheme = { isCodeDarkTheme = !isCodeDarkTheme }
        ) {
            """
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 120.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) { item ->
                    ListItemComponent(item)
                }
            }
            """.trimIndent()
        }
    }
}
