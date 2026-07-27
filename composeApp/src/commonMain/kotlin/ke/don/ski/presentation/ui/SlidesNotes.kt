package ke.don.ski.presentation.ui

import androidx.compose.ui.text.AnnotatedString

val introductionNotes = listOf(
    AnnotatedString("Remember to say hallo"),
    AnnotatedString("Say something cool")
)

val objectivesNotes = listOf(
    AnnotatedString("Most Android developers don't intentionally build bad tablet apps."),
    AnnotatedString("They build excellent phone apps that accidentally run on tablets."),
    AnnotatedString("Adaptive UI isn't about making everything larger."),
    AnnotatedString("It's about making better use of available space."),
    AnnotatedString("The session progressively scales from the smallest UI building block to the largest architectural unit.")
)

val wrongPictureNotes = listOf(
    AnnotatedString("Look at this layout on a folded device."),
    AnnotatedString("It looks fine, right? It's a standard mobile layout."),
    AnnotatedString("But watch what happens when we unfold the device or move to a tablet."),
    AnnotatedString("The 'stretch' problem: Everything just gets wider, but not better.")
)

val componentIntroNotes = listOf(
    AnnotatedString("Components"),
    AnnotatedString("Adaptation Starts Small"),
    AnnotatedString("Before redesigning entire screens, make individual components flexible.")
)

val flowRowNotes = listOf(
    AnnotatedString("FlowRow allows items to wrap naturally when they hit the edge of the container."),
    AnnotatedString("This is the first step in making a component adaptive—letting it flow.")
)

val flexBoxNotes = listOf(
    AnnotatedString("FlexBox takes FlowRow further by allowing items to grow and fill remaining space."),
    AnnotatedString("It gives you fine-grained control over how items behave in a wrapping layout.")
)

val marqueeNotes = listOf(
    AnnotatedString("Marquee is great for secondary information that might be too long."),
    AnnotatedString("Instead of truncating with '...', we can scroll the text to ensure it's still accessible.")
)

val gridNotes = listOf(
    AnnotatedString("The experimental Grid API allows for rigid but responsive layouts."),
    AnnotatedString("You can programmatically change columns and rows based on the available width.")
)

val layoutsIntroNotes = listOf(
    AnnotatedString("Layouts: How do components interact?"),
    AnnotatedString("We've seen individual components, now let's see how they work together to form meaningful structures.")
)

val heroComponentNotes = listOf(
    AnnotatedString("The Hero segment is a classic use case for adaptive components."),
    AnnotatedString("Small screen: Focus on glanceability and core actions."),
    AnnotatedString("Large screen: Use the space for immersive imagery and more detailed description."),
    AnnotatedString("The focusable interaction allows us to transition from a list item to a dedicated detail view.")
)

val layoutsSummaryNotes = listOf(
    AnnotatedString("Column vs Row: The fundamental choice."),
    AnnotatedString("Most layouts are just nested rows and columns."),
    AnnotatedString("A profile header in a card is a great example of when to switch axes based on width.")
)

val collectionIntroNotes = listOf(
    AnnotatedString("Part 3 — Lists Aren't Always Lists"),
    AnnotatedString("Components adapt. Collections should too.")
)

val collectionProblemNotes = listOf(
    AnnotatedString("Why are we still pretending there's only one column?"),
    AnnotatedString("Stretching a single-column list across a tablet width makes it hard to scan and waste space.")
)

val collectionGridNotes = listOf(
    AnnotatedString("LazyVerticalGrid and LazyHorizontalGrid allow for multi-column/row layouts."),
    AnnotatedString("Staggered variants also help with dynamic content heights.")
)

val collectionStaggeredGridNotes = listOf(
    AnnotatedString("LazyVerticalStaggeredGrid handles items with different aspect ratios efficiently."),
    AnnotatedString("It prevents the 'empty pockets' of space that regular grids might have when items are uneven.")
)

val collectionPaginationNotes = listOf(
    AnnotatedString("Endless scroll works well for mobile/main features."),
    AnnotatedString("Paging bars can be better when the collection is just part of a larger, complex screen.")
)
