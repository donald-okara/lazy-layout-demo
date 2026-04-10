package ke.don.demos.list_examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumn_StickyHeader_Example(
    modifier: Modifier = Modifier
){
    val items = generatePastelList()

    val groupedItems = remember(items) {
        groupItems(items)
    }

    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        groupedItems.forEach { (type, sectionItems) ->
            stickyHeader {
                Header(type)
            }

            items(
                items = sectionItems,
                key = {it.id}
            ){ item ->
                ListItemComponent(model = item)
            }
        }
    }
}

fun groupItems(items: List<ListModel>): List<Pair<ItemType, List<ListModel>>> {
    return ItemType.entries.mapNotNull { type ->
        val sectionItems = items.filter { it.type == type }
        if (sectionItems.isEmpty()) return@mapNotNull null
        type to sectionItems
    }
}

@Composable
private fun Header(type: ItemType) {
    Text(
        text = type.name,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(16.dp)
    )
}