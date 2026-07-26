package ke.don.demos.slides

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ke.don.demos.list_examples.Pastel
import ke.don.demos.list_examples.RoundedBox

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LayoutsSummarySlide(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(48.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Column {
            Text(
                "Column vs Row",
                style = MaterialTheme.typography.displaySmallEmphasized,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Choosing the right primary axis for your components.",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            // Column Case
            SummaryCard(
                modifier = Modifier.weight(1f),
                title = "Vertical (Column)",
                subtitle = "Best for narrow containers or centered focus.",
                recommendation = "Use when width < 240dp"
            ) {
                ProfileHeader(isRow = false)
            }

            // Row Case
            SummaryCard(
                modifier = Modifier.weight(1.5f),
                title = "Horizontal (Row)",
                subtitle = "Best for wide cards or list items.",
                recommendation = "Use when width > 360dp"
            ) {
                ProfileHeader(isRow = true)
            }
        }
    }
}

@Composable
private fun SummaryCard(
    title: String,
    subtitle: String,
    recommendation: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.fillMaxHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp)
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                content()
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(subtitle, style = MaterialTheme.typography.bodyMedium)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        recommendation,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(isRow: Boolean) {
    val content = @Composable {
        // Avatar
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Pastel.Lavender.color)
        )
        
        if (isRow) Spacer(modifier = Modifier.width(16.dp)) else Spacer(modifier = Modifier.height(12.dp))

        Column(
            horizontalAlignment = if (isRow) Alignment.Start else Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(12.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(8.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(Color.Black.copy(alpha = 0.2f))
            )
        }
    }

    if (isRow) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            content()
        }
    } else {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            content()
        }
    }
}
