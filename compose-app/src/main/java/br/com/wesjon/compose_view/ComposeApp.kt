package br.com.wesjon.compose_view


import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.ui.tooling.preview.Preview
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen

@Preview
@Composable
fun ComposeApp() {
    var currentRoute: Routing = remember { Routing.HomeScreen }
    ScaffoldScreen(title = currentRoute.title) {
        when (currentRoute) {
            is Routing.HomeScreen -> HomeScreen { currentRoute = it.route }
            is Routing.ExampleLinearLayoutLike -> LinearLayoutScreen()
            is Routing.ExampleScrollableLists -> ScrollableListScreen()
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
            TopAppBar(title = { Text(title) })
        },
        bodyContent = { MaterialTheme(content = bodyContent) }
    )
}
