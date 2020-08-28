package br.com.wesjon.compose_view

sealed class Routing(val title: String) {
    object HomeScreen : Routing("Jetpack Compose Examples")
    object ExampleLinearLayoutLike : Routing("LinearLayout")
    object ExampleScrollableLists : Routing("ScrollableLists")
    object GmailLikeLayout : Routing("GmailLikeLayout")
}