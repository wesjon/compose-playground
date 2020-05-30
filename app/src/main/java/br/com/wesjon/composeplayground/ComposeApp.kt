package br.com.wesjon.composeplayground

import androidx.compose.Composable
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

@Composable
fun ComposeApp() {
    ExampleList()
}

@Preview
@Composable
fun ExampleList() {
    MaterialTheme {
        Box(backgroundColor = Color.Cyan){
            Greeting(name = "João")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}