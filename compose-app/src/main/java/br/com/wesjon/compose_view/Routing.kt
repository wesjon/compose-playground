package br.com.wesjon.compose_view

import java.io.Serializable

data class Routing(val title: String): Serializable

val HomeScreen = Routing("Jetpack Compose Examples")
val ExampleLinearLayoutLike = Routing("LinearLayout")
val ExampleScrollableLists = Routing("ScrollableLists")
val GmailLikeLayout = Routing("GmailLikeLayout")
val NuBankUI = Routing("Nubank UI")