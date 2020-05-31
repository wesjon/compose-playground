package br.com.wesjon.compose_view.screen

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.unit.dp
import br.com.wesjon.compose_view.domain.Example
import br.com.wesjon.compose_view.domain.examplesList

@Composable
fun HomeScreen(onExampleClicked: (Example) -> Unit) {
    MaterialTheme {
        Box(backgroundColor = MaterialTheme.colors.background) {
            Column {
                TopAppBar(
                    title = { Text("Jetpack Compose Examples") }
                )

                ExamplesList(onExampleClicked)
            }
        }
    }
}

@Composable
fun ExamplesList(onExampleClicked: (Example) -> Unit) {
    AdapterList(
        data = examplesList,
        modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
    ) {
        ExampleListItem(it, onExampleClicked)
    }
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