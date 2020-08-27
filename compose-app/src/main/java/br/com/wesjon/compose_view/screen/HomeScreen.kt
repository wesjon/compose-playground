package br.com.wesjon.compose_view.screen

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wesjon.compose_view.model.Example
import br.com.wesjon.compose_view.model.examplesList

@Composable
fun HomeScreen(onExampleClicked: (Example) -> Unit) {
    MaterialTheme {
        Box(backgroundColor = MaterialTheme.colors.background) {
            ExamplesList(onExampleClicked)
        }
    }
}

@Composable
fun ExamplesList(onExampleClicked: (Example) -> Unit) {
    LazyColumnFor(items = examplesList,
        modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp),
        itemContent = {
            ExampleListItem(it, onExampleClicked)
        })
}

@Composable
fun ExampleListItem(
    example: Example,
    onExampleClicked: (Example) -> Unit
) {
    Button(
        onClick = { onExampleClicked.invoke(example) },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxSize() + Modifier.padding(16.dp, 0.dp, 8.dp, 16.dp),
        enabled = example.isImplemented
    ) {
        Text(text = example.name)
    }
}