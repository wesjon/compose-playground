package br.com.wesjon.compose_view.screen.nubank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
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

@Preview(
    showBackground = true,
    device = Devices.PIXEL_2
)
@Composable
fun NubankScreen(uiModel: NubankUiModel = clientOne) {
    val valuesVisible = remember { mutableStateOf(true) }

    NubankTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(vertical = 16.dp)
        ) {
            TopItems(
                clientName = uiModel.clientName,
                valuesVisible = valuesVisible.value,
                onToggleVisibility = {
                    valuesVisible.value = !valuesVisible.value
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CardSections(
                uiModel = uiModel,
                valuesVisible = valuesVisible.value,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            BottomCards(uiModel)
        }
    }
}

@Composable
fun TopItems(
    clientName: String,
    onToggleVisibility: () -> Unit,
    modifier: Modifier,
    valuesVisible: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "Olá, $clientName",
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
fun CardSections(uiModel: NubankUiModel, modifier: Modifier, valuesVisible: Boolean) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        CreditCardCard(uiModel, valuesVisible)
        NuConta(uiModel.checkingBalance, valuesVisible)
    }
}

@Composable
fun CreditCardCard(uiModel: NubankUiModel, valuesVisible: Boolean) {
    NuCard(Icons.Outlined.CardGiftcard, "Cartão de crédito") {
        Text(
            text = "Fatura atual",
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface,
        )

        val creditCardValues = if (valuesVisible) {
            uiModel.currentInvoiceValue
        } else {
            "-"
        }
        Text(
            text = creditCardValues,
            style = BigValueTextStyle,
            color = MaterialTheme.colors.blue
        )

        Row {
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.onSecondary,
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
                    if (valuesVisible) {
                        append(uiModel.remainingLimitValue)
                    } else {
                        append("-")
                    }
                }
            })
        }
    }
}

@Composable
fun NuConta(balance: String, valuesVisible: Boolean) {
    NuCard(icon = Icons.Outlined.MonetizationOn, title = "Conta") {
        Text(
            text = "Saldo disponível",
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface,
        )
        val displayText = if (valuesVisible) {
            balance
        } else {
            "-"
        }

        Text(
            displayText,
            style = BigValueTextStyle,
            color = MaterialTheme.colors.strongText
        )
    }
}

@Composable
fun BottomCards(uiModel: NubankUiModel) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(count = uiModel.bottomBarOptions.size) { index ->
            val (icon, title) = uiModel.bottomBarOptions[index]
            BottomCard(icon = icon.icon, title = title.title)
        }
    }
}
