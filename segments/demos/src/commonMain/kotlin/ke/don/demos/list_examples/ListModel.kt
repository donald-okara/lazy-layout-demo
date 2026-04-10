package ke.don.demos.list_examples

import androidx.compose.ui.graphics.Color

data class ListModel(
    val id: Int,
    val color: Color,
    val aspectRatio: Float
)

fun generatePastelList(iterations: Int = 5): List<ListModel> {
    val base = listOf(
        Color(0xFFFFC1CC) to 1f,
        Color(0xFFB5EAD7) to 1.5f,
        Color(0xFFC7CEEA) to 0.75f,
        Color(0xFFFFDAC1) to 1.2f,
        Color(0xFFE2F0CB) to 1.8f,
        Color(0xFFFFF1BA) to 1f
    )

    return List(iterations) { iteration ->
        base.mapIndexed { index, (color, ratio) ->
            ListModel(
                id = iteration * base.size + index,
                color = color,
                aspectRatio = ratio
            )
        }
    }.flatten()
}