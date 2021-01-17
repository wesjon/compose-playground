package br.com.wesjon.compose_view


import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen

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
