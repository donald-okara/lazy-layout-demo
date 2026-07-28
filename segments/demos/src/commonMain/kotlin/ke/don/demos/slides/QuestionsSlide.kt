package ke.don.demos.slides

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

data class SocialMedia(
    val platform: String,
    val handle: String
)

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun QuestionsSlide(
    modifier: Modifier = Modifier
) {
    val socials = listOf(
        SocialMedia("GitHub", "donald-okara"),
        SocialMedia("X", "@don_okara"),
        SocialMedia("LinkedIn", "Donald Isoe")
    )

    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        startAnimation = true
    }

    val anyOffset by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else (-300).dp,
        animationSpec = tween(1000)
    )

    val questionsOffset by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 300.dp,
        animationSpec = tween(1000)
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(48.dp)
    ) {
        // "Any" Panel - Top Left
        Surface(
            modifier = Modifier
                .offset(x = anyOffset, y = anyOffset)
                .align(Alignment.TopStart),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 8.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {
                Text(
                    "Any",
                    style = MaterialTheme.typography.displayLargeEmphasized,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        // "Questions" Panel - Middle Far Right
        Surface(
            modifier = Modifier
                .offset(x = questionsOffset)
                .align(Alignment.CenterEnd),
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 8.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {
                Text(
                    "Questions?",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }

        // Socials Marquee - Bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = socials.joinToString("   •   ") { "${it.platform}: ${it.handle}" },
                modifier = Modifier
                    .fillMaxWidth()
                    .basicMarquee(iterations = Int.MAX_VALUE),
                style = MaterialTheme.typography.titleLarge.copy(
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Medium
                ),
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
