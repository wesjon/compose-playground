package br.com.wesjon.compose_view


import androidx.compose.material.*
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
                title = { Text(title) }
            )
        },
        content = { MaterialTheme(content = bodyContent) }
    )
}
