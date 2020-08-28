package br.com.wesjon.compose_view.model

import br.com.wesjon.compose_view.Routing

data class Example(
    val name: String,
    val route: Routing = Routing.HomeScreen,
    val isImplemented: Boolean = false
)

val examplesList = listOf(
    Example("LinearLayout like layouts", Routing.ExampleLinearLayoutLike, true),
    Example("Scrollable lists", Routing.ExampleScrollableLists, true),
    Example("Gmail like list", Routing.GmailLikeLayout, true),
    Example("Nubank UI", Routing.NuBankUI, false)
)