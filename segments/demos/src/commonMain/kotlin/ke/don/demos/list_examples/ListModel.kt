package ke.don.demos.list_examples

import androidx.compose.ui.graphics.Color

data class ListModel(
    val id: Int,
    val color: Color,
    val aspectRatio: Float,
    val type: ItemType = ItemType.Vibes
)

enum class ItemType {
    Vibes, Inshallah, Fam, Oya
}

fun generatePastelList(iterations: Int = 5): List<ListModel> {
    val base = listOf(
        Triple(Color(0xFFFFC1CC), 1f, ItemType.Vibes),
        Triple(Color(0xFFB5EAD7), 1.5f, ItemType.Inshallah),
        Triple(Color(0xFFC7CEEA), 0.75f, ItemType.Fam),
        Triple(Color(0xFFFFDAC1), 1.2f, ItemType.Oya),
        Triple(Color(0xFFE2F0CB), 1.8f, ItemType.Vibes),
        Triple(Color(0xFFFFF1BA), 1f, ItemType.Inshallah),
    )

    return List(iterations) { iteration ->
        base.mapIndexed { index, (color, ratio, type) ->
            ListModel(
                id = iteration * base.size + index,
                color = color,
                aspectRatio = ratio,
                type = type
            )
        }
    }.flatten()
}