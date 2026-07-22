package ke.don.demos.list_examples

import androidx.compose.ui.graphics.Color

data class ListModel(
    val id: Int,
    val color: Color,
    val aspectRatio: Float,
    val type: ItemType = ItemType.Vibes
)

enum class Pastel(val color: Color) {
    Pink(Color(0xFFFFC1CC)),
    Mint(Color(0xFFB5EAD7)),
    Lavender(Color(0xFFC7CEEA)),
    Peach(Color(0xFFFFDAC1)),
    Lime(Color(0xFFE2F0CB)),
    Yellow(Color(0xFFFFF1BA))
}

enum class ItemType {
    Vibes, Inshallah, Fam, Oya
}

fun generatePastelList(iterations: Int = 5): List<ListModel> {
    val base = listOf(
        Triple(Pastel.Pink.color, 1f, ItemType.Vibes),
        Triple(Pastel.Mint.color, 1.5f, ItemType.Inshallah),
        Triple(Pastel.Lavender.color, 0.75f, ItemType.Fam),
        Triple(Pastel.Peach.color, 1.2f, ItemType.Oya),
        Triple(Pastel.Lime.color, 1.8f, ItemType.Vibes),
        Triple(Pastel.Yellow.color, 1f, ItemType.Inshallah),
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