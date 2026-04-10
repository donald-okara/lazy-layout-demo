package ke.don.demos.list_examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowExample(
    modifier: Modifier = Modifier
) {
    val items = generatePastelList()
    LazyRow(
        modifier = modifier
            .padding(8.dp)
            .height(150.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(items){
            ListItemComponent(model = it)
        }
    }
}