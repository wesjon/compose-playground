package br.com.wesjon.compose_view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
fun GmailScreen() {
    LazyColumn {
        items(count = 6, itemContent = {
            EmailItem(emails[it % 2])
        })
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
                Icons.Default.Star
            } else {
                Icons.Outlined.Star
            }

            IconButton(
                content = { Icon(icon, "") },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {}
            )
        }
    }
}

@Composable
fun ContactImage(name: String) {
    Box {
        Spacer(
            modifier = Modifier
                .size(48.dp)
                .background(
                    Color.Gray,
                    shape = CircleShape
                ),
        )

        Text(
            text = name.first().toString(),
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}