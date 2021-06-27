package br.com.wesjon.compose_view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wesjon.compose_view.screen.nubank.*

@Preview(
    showBackground = true,
    device = Devices.PIXEL_2
)
@Composable
fun NubankScreen() {
    val valuesVisible = remember { mutableStateOf(true) }

    Surface(
        color = NubankPrimaryColor,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            TopItems(
                valuesVisible = valuesVisible.value,
                onToggleVisibility = {
                    valuesVisible.value = !valuesVisible.value
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CardSections(
                valuesVisible = valuesVisible.value,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            BottomCards()
        }
    }
}

@Composable
fun TopItems(
    valuesVisible: Boolean,
    onToggleVisibility: () -> Unit,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "Olá, Wesley",
            modifier = Modifier.weight(1f),
            color = Color.White,
            style = MaterialTheme.typography.h4
        )

        val visibilityIcon = if (valuesVisible) {
            Icons.Outlined.VisibilityOff
        } else {
            Icons.Outlined.Visibility
        }
        ActionIcon(visibilityIcon, onClick = onToggleVisibility)
        ActionIcon(Icons.Outlined.Settings)
    }
}

@Composable
fun CardSections(valuesVisible: Boolean, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        CreditCardCard(valuesVisible)
        NuConta()
    }
}

@Composable
fun CreditCardCard(valuesVisible: Boolean) {
    NuCard(Icons.Outlined.CardGiftcard, "Cartão de crédito") {
        Text(
            text = "Fatura atual",
            style = MaterialTheme.typography.subtitle2,
            color = NubankSecondaryColor,
        )

        val creditCardValues = if (valuesVisible) {
            "R$ 1.000,00"
        } else {
            "-"
        }
        Text(
            text = creditCardValues,
            style = BigValueTextStyle,
            color = NubankBlueColor
        )

        Row {
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = NubankSecondaryTextColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                ) {
                    append("Limite disponível ")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color(0xff1E7E44),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("R$ 150,00")
                }
            })
        }
    }
}

@Composable
fun NuConta() {
    NuCard(icon = Icons.Outlined.MonetizationOn, title = "Conta") {
        Text(
            text = "Saldo disponível",
            style = MaterialTheme.typography.subtitle2,
            color = NubankSecondaryColor,
        )
        Text(
            "R$ 500,00",
            style = BigValueTextStyle,
            color = NubankBigValueStrongColor
        )
    }
}

@Composable
fun BottomCards() {
    val bottomItems = listOf(
        Icons.Outlined.Payment to "Pix",
        Icons.Outlined.Money to "Pagar",
        Icons.Outlined.Contacts to "Indicar amigo",
        Icons.Outlined.TransferWithinAStation to "Transferir",
        Icons.Outlined.Adjust to "Ajustar limite",
        Icons.Outlined.Payment to "Pix",
        Icons.Outlined.TransferWithinAStation to "Transferir",
        Icons.Outlined.Adjust to "Ajustar limite",
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(count = bottomItems.size) { index ->
            val (icon, title) = bottomItems[index]
            BottomCard(icon = icon, title = title)
        }
    }
}
