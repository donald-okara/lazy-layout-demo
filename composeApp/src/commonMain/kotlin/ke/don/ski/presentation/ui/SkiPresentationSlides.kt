package ke.don.ski.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import io.github.donald_okara.components.timer.TimerController
import ke.don.demos.DeviceGallery
import ke.don.demos.ExampleSlide
import ke.don.demos.HorizontalSegmentsDemo
import ke.don.demos.KodeViewerSlide
import ke.don.demos.VerticalSegmentsDemo
import ke.don.demos.WhiteboardSlide
import ke.don.demos.slides.SessionObjectives
import ke.don.demos.slides.WrongPictureSlide
import ke.don.demos.slides.ComponentIntroSlide
import ke.don.demos.slides.FlowRowSlide
import ke.don.demos.slides.FlexBoxSlide
import ke.don.demos.slides.MarqueeSlide
import ke.don.demos.slides.GridSlide
import ke.don.demos.slides.LayoutsIntroSlide
import ke.don.demos.slides.HeroComponentSlide
import ke.don.demos.slides.LayoutsSummarySlide
import ke.don.demos.slides.CollectionIntroSlide
import ke.don.demos.slides.CollectionProblemSlide
import ke.don.demos.slides.CollectionGridSlide
import ke.don.demos.slides.CollectionStaggeredGridSlide
import ke.don.demos.slides.CollectionPaginationSlide
import ke.don.domain.ScreenTransition
import ke.don.introduction.IntroductionScreen
import ke.don.ski.SlidesConstants.SESSION_DURATION
import ke.don.ski.domain.SlideConfig
import ke.don.ski.domain.generateDeck
import kotlin.time.Duration

@Composable
fun skiPresentationSlides(sessionDuration: Duration = SESSION_DURATION): List<SlideConfig> {
    val timerController = rememberTimerController(sessionDuration)

    val slides = remember(timerController) {
            generateDeck(
                timerController = timerController
            ) {
                slide(
                    "Introduction",
                    transition = ScreenTransition.Fade,
                    notes = introductionNotes,
                    footer = null
                ) {
                    IntroductionScreen()
                }
                slide("What is wrong?", notes = wrongPictureNotes) {
                    WrongPictureSlide()
                }
                slide("Objectives", notes = objectivesNotes) {
                    SessionObjectives()
                }
                slide("Components Intro", notes = componentIntroNotes) {
                    ComponentIntroSlide()
                }
                slide("FlowRow", notes = flowRowNotes) {
                    FlowRowSlide()
                }

                slide("Marquee", notes = marqueeNotes) {
                    MarqueeSlide()
                }
                slide("FlexBox", notes = flexBoxNotes) {
                    FlexBoxSlide()
                }
                slide("Grid", notes = gridNotes) {
                    GridSlide()
                }
                slide("Layouts Intro", notes = layoutsIntroNotes) {
                    LayoutsIntroSlide()
                }
                slide("Adaptive Hero", notes = heroComponentNotes) {
                    HeroComponentSlide()
                }
                slide("Layouts Summary", notes = layoutsSummaryNotes) {
                    LayoutsSummarySlide()
                }
                slide("Collection Intro", notes = collectionIntroNotes) {
                    CollectionIntroSlide()
                }
                slide("Collection Problem", notes = collectionProblemNotes) {
                    CollectionProblemSlide()
                }
                slide("Collection Grid", notes = collectionGridNotes) {
                    CollectionGridSlide()
                }
                slide("Collection Staggered Grid", notes = collectionStaggeredGridNotes) {
                    CollectionStaggeredGridSlide()
                }
                slide("Collection Pagination", notes = collectionPaginationNotes) {
                    CollectionPaginationSlide()
                }
                slide("Example Screen") {
                    ExampleSlide()
                }
                slide("Kode Viewer", notes = kodeViewerNotes) {
                    KodeViewerSlide()
                }
                slide("Whiteboard Screen", notes = whiteboardNotes){
                    WhiteboardSlide()
                }
                slide("Vertical Segments Demo") {
                    VerticalSegmentsDemo()
                }
                slide("Horizontal Segments Demo") {
                    HorizontalSegmentsDemo()
                }
                slide("Device Frames"){
                    DeviceGallery()
                }
            }
        }
    return slides
}
@Composable
fun rememberTimerController(
    sessionDuration: Duration
): TimerController {
    val scope = rememberCoroutineScope()
    return remember(scope, sessionDuration) {
        TimerController(scope, sessionDuration)
    }
}