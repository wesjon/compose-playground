package br.com.wesjon.compose_view.screen

import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

data class Email(
    val name: String,
    val subject: String,
    val time: String,
    val isStared: Boolean
)

val emails = listOf(
    Email("João da Silva", "Super promoção, não perca", "18:32", true),
    Email("Maria", "E-mail super importante", "14:22", false),
)

@Composable
@Preview
fun GmailScreen() {
    LazyColumnFor(items = emails + emails + emails) {
        EmailItem(it)
    }
}

@Composable
fun EmailItem(email: Email) {
    Row(Modifier.padding(16.dp)) {
        ContactImage(email.name)

        Column(
            Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(email.name)
            Text(email.subject)
        }

        Column {
            Text(email.time)

            val icon = if (email.isStared) {
                Icons.Filled.Star
            } else {
                Icons.Outlined.Star
            }

            Icon(icon, Modifier.gravity(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun ContactImage(name: String) {
    Stack {
        Box(
            backgroundColor = Color.Gray,
            modifier = Modifier.size(48.dp),
            shape = CircleShape
        )

        Text(
            text = name.first().toString(),
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            ),
            modifier = Modifier.gravity(Alignment.Center)
        )
    }
}