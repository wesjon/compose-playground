package br.com.wesjon.compose_view.screen.nubank

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

@JvmInline
value class NuIcon(val icon: ImageVector)

@JvmInline
value class Title(val title: String)

data class NubankUiModel(
    val clientName: String,
    val currentInvoiceValue: String,
    val remainingLimitValue: String,
    val checkingBalance: String,
    val bottomBarOptions: List<Pair<NuIcon, Title>>
)

val clientOne = NubankUiModel(
    clientName = "John",
    currentInvoiceValue = "R$ 1520,65",
    remainingLimitValue = "R$ 150,00",
    checkingBalance = "R$ 888,00",
    bottomBarOptions = listOf(
        NuIcon(Icons.Outlined.Payment) to Title("Pix"),
        NuIcon(Icons.Outlined.Money) to Title("Pagar"),
        NuIcon(Icons.Outlined.Contacts) to Title("Indicar amigo"),
        NuIcon(Icons.Outlined.TransferWithinAStation) to Title("Transferir"),
        NuIcon(Icons.Outlined.Adjust) to Title("Ajustar limite"),
        NuIcon(Icons.Outlined.Payment) to Title("Pix"),
        NuIcon(Icons.Outlined.TransferWithinAStation) to Title("Transferir"),
        NuIcon(Icons.Outlined.Adjust) to Title("Ajustar limite"),
    )
)