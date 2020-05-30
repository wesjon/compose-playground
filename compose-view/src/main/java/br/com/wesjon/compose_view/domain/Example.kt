package br.com.wesjon.compose_view.domain

data class Example(
    val name: String,
    val isImplemented: Boolean = false
)

val examplesList = listOf(
    Example("LinearLayout like layouts", true),
    Example("Scrollable lists"),
    Example("Gmail like list")
)