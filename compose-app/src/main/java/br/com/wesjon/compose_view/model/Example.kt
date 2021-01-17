package br.com.wesjon.compose_view.model

import br.com.wesjon.compose_view.*

data class Example(
    val name: String,
    val route: Routing = HomeScreen,
    val isImplemented: Boolean = false
)

val examplesList = listOf(
    Example("LinearLayout like layouts", ExampleLinearLayoutLike, true),
    Example("Scrollable lists", ExampleScrollableLists, true),
    Example("Gmail like list", GmailLikeLayout, true),
    Example("Nubank UI", NuBankUI, false)
)