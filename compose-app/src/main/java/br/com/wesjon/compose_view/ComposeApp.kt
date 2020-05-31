package br.com.wesjon.compose_view

import androidx.compose.Composable
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen
import com.github.zsoltk.compose.router.Router

@Composable
fun ComposeApp(defaultRouting: Routing) {
    Router("homescreen", defaultRouting) { backStack ->
        when (val routing = backStack.last()) {
            is Routing.HomeScreen -> HomeScreen {
                if (it.route != null) {
                    backStack.push(it.route)
                }
            }
            is Routing.ExampleLinearLayoutLike -> LinearLayoutScreen()
            is Routing.ExampleScrollableLists -> ScrollableListScreen()
        }
    }
}