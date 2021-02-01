package br.com.wesjon.compose_view


import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ComposeApp() {

}

@Composable
fun ScaffoldScreen(
    title: String,
    bodyContent: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
            )
        },
        bodyContent = { MaterialTheme(content = bodyContent) }
    )
}
