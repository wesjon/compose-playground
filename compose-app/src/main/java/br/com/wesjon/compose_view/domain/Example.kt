package br.com.wesjon.compose_view.domain

import br.com.wesjon.compose_view.Routing

data class Example(
    val name: String,
    val route: Routing? = null,
    val isImplemented: Boolean = false
)

val examplesList = listOf(
    Example("LinearLayout like layouts", Routing.ExampleLinearLayoutLike, true),
    Example("Scrollable lists", Routing.ExampleScrollableLists, true),
    Example("Gmail like list")
)