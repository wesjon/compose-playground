package br.com.wesjon.compose_view.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Example(
    val title: String,
    val isImplemented: Boolean = true,
    val showToolbar: Boolean = true,
) : Parcelable {
    LINEAR_LAYOUT("LinearLayout like layouts", true),
    SCROLLABLE_LISTS("Scrollable lists", true),
    GMAIL("Gmail like list", true),
    NUBANK("Nubank UI", true, false)
}