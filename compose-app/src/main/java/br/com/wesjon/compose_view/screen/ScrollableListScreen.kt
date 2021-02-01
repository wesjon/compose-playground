package br.com.wesjon.compose_view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wesjon.compose_view.extension.isOdd


private val boxSize = 60.dp
private val coolColors = listOf(
    Color.Blue, Color.Cyan, Color.Green, Color.Magenta, Color.Yellow, Color.Red
)

@Composable
fun ScrollableListScreen() {
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
        items(count = 20,
            itemContent = { index ->
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
            })
    }
}

@Composable
fun ListItemTypeA() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(boxSize)
            .background(coolColors.random())
    )
}

@Composable
fun ListItemTypeB() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(boxSize * 2)
            .background(coolColors.random())
    )
}