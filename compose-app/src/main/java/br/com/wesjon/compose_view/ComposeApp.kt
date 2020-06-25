package br.com.wesjon.compose_view

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen
import com.github.zsoltk.compose.router.BackStack
import com.github.zsoltk.compose.router.Router

@Composable
fun ComposeApp(defaultRouting: Routing) {
    Router("homescreen", defaultRouting) { backStack ->
        val routing = backStack.last()
        ScaffoldScreen(backStack, title = routing.title) {
            when (routing) {
                is Routing.HomeScreen -> HomeScreen { backStack.push(it.route) }
                is Routing.ExampleLinearLayoutLike -> LinearLayoutScreen()
                is Routing.ExampleScrollableLists -> ScrollableListScreen()
            }
        }
    }
}

@Composable
fun ScaffoldScreen(
    backStack: BackStack<Routing>,
    title: String,
    bodyContent: @Composable() () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title) })
        },
        bodyContent = { MaterialTheme(content = bodyContent) }
    )
}