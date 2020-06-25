package br.com.wesjon.compose_view.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.graphics.Color
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.unit.dp
import br.com.wesjon.compose_view.extension.isOdd

private val boxSize = 60.dp
private val coolColors = listOf(
    Color.Blue, Color.Cyan, Color.Green, Color.Magenta, Color.Yellow, Color.Red
)

@Composable
fun ScrollableListScreen() {
    LazyColumnItems(
        items = (0..20).toList(),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) { index ->
        // Here is the equivalent to "onCreateViewHolder", build your listItem here

        if (index == 0) {
            Spacer(modifier = Modifier.height(8.dp))
        }

        // The equivalent of multiple ViewTypes can be expressed as conditions here
        if (index.isOdd()) {
            ListItemTypeA()
        } else {
            ListItemTypeB()
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ListItemTypeA() {
    Box(
        modifier = Modifier.fillMaxWidth() + Modifier.height(boxSize),
        backgroundColor = coolColors.random()
    )
}

@Composable
fun ListItemTypeB() {
    Box(
        modifier = Modifier.fillMaxWidth() + Modifier.height(boxSize * 2),
        backgroundColor = coolColors.random()
    )
}