package br.com.wesjon.compose_view

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Preview
@Composable
fun HomeScreen() {
    MaterialTheme {
        Box(backgroundColor = Color.White) {
            Column {
                Text(
                    "Jetpack Compose Examples",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.fillMaxWidth() + Modifier.padding(16.dp)
                )

                ExamplesList()
            }
        }
    }
}

@Composable
fun ExamplesList() {
    AdapterList(
        data = listOf("A", "B", "C"),
        modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
    ) {
        ExampleListItem(it)
    }
}

@Composable
fun ExampleListItem(exampleName: String) {
    Button(
        onClick = {},
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxSize() + Modifier.padding(16.dp, 0.dp, 8.dp, 16.dp)
    ) {
        Text(text = exampleName)
    }
}
