package ke.don.demos.slides

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ke.don.demos.list_examples.ContentLines
import ke.don.demos.list_examples.ListItemComponent
import ke.don.demos.list_examples.generatePastelList

@Composable
fun CollectionProblemSlide(
    modifier: Modifier = Modifier
) {
    val items = generatePastelList()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            "The Problem: Stretching",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Mobile simulation
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Phone Feed", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .fillMaxHeight()
                        .border(1.dp, Color.Gray)
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items) {
                            ListItemComponent(
                                it,
                                contentAlignment = Alignment.BottomStart,
                                modifier = Modifier.fillMaxWidth(),
                                content = {
                                    ContentLines()
                                }
                            )
                        }
                    }
                }
            }

            // Tablet simulation
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Tablet Feed (Stretched)", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .fillMaxHeight()
                        .border(1.dp, Color.Gray)
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items) {
                            ListItemComponent(
                                model = it,
                                modifier = Modifier.fillMaxWidth(),
                                content = {
                                    ContentLines()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
