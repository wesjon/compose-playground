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
import br.com.wesjon.compose_view.screen.GmailScreen
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen

@Preview
@Composable
fun ComposeApp() {
    val currentRoute: MutableState<Routing> = remember { mutableStateOf(Routing.HomeScreen) }
    ScaffoldScreen(title = currentRoute.value.title) {
        when (currentRoute.value) {
            Routing.HomeScreen -> HomeScreen { currentRoute.value = it.route }
            Routing.ExampleLinearLayoutLike -> LinearLayoutScreen()
            Routing.ExampleScrollableLists -> ScrollableListScreen()
            Routing.GmailLikeLayout -> GmailScreen()
        }
    }
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
