package ke.don.demos.slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.LinearBullet
import io.github.donald_okara.components.layout.HorizontallySegmentedScreen
import kotlinx.coroutines.delay

import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SessionObjectives(
    modifier: Modifier = Modifier,
) {
    var animationStep by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        // Sequentially trigger animations
        for (i in 1..9) {
            delay(500.milliseconds)
            animationStep = i
        }
    }

    HorizontallySegmentedScreen(
        modifier = modifier.fillMaxSize().padding(48.dp),
        initialSegments = listOf(
            1f to {
                ObjectivesSegment(animationStep)
            },
            1f to {
                MentalModelSegment(animationStep)
            },
        )
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun ObjectivesSegment(animationStep: Int) {
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(end = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        AnimatedVisibility(
            visible = animationStep >= 1,
            enter = fadeIn() + slideInVertically()
        ) {
            Text(
                "By the end of this session, we should be able to",
                style = MaterialTheme.typography.headlineLargeEmphasized,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        ObjectiveItem(
            text = "Stop thinking about adaptive layouts as \"making phone layouts bigger\"",
            visible = animationStep >= 2
        )

        Spacer(modifier = Modifier.height(16.dp))

        ObjectiveItem(
            text = "Understand how to make the device size work for you",
            visible = animationStep >= 3
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun ObjectiveItem(text: String, visible: Boolean) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(500)) + slideInVertically(tween(500)) { it / 2 }
    ) {
        Row(verticalAlignment = Alignment.Top) {
            LinearBullet(height = 40)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text,
                style = MaterialTheme.typography.bodyLargeEmphasized
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun MentalModelSegment(animationStep: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = animationStep >= 4,
            enter = fadeIn()
        ) {
            Text(
                "Mental model",
                style = MaterialTheme.typography.headlineMediumEmphasized,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        val steps = listOf("Component", "Layout", "Collection", "Screen", "Scene")
        steps.forEachIndexed { index, step ->
            val stepIndex = index + 4 // Starts from 4 (Title)
            
            if (index > 0) {
                AnimatedVisibility(
                    visible = animationStep > stepIndex,
                    enter = fadeIn()
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline
                    )
                }
            }

            AnimatedVisibility(
                visible = animationStep >= (stepIndex + 1),
                enter = fadeIn() + slideInVertically { it / 2 }
            ) {
                Text(
                    step,
                    style = MaterialTheme.typography.titleLargeEmphasized,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
