package io.github.donald_okara.components.timer

import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

data class TimerState(
    val status: TimerStatus = TimerStatus.Idle,
    val totalTime: Duration = 45.minutes,
    val timeLeft: Duration = totalTime
)