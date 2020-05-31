package br.com.wesjon.compose_view

import androidx.compose.Composable
import br.com.wesjon.compose_view.screen.HomeScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import com.github.zsoltk.compose.router.Router

@Composable
fun ComposeApp(defaultRouting: Routing) {
    Router("homescreen", defaultRouting) { backStack ->
        when (val routing = backStack.last()) {
            is Routing.HomeScreen -> HomeScreen {
                backStack.push(Routing.ExampleLinearLayoutLike)
            }
            is Routing.ExampleLinearLayoutLike -> LinearLayoutScreen()
        }
    }
}