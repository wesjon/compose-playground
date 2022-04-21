package br.com.wesjon.compose_view.screen.nubank

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val NubankPurple = Color(0xFF810AD1)
private val NubankSecondaryColor = Color(0xFF707070)
private val NubankBlueColor = Color(0xFF25A1DE)
private val NubankSecondaryTextColor = Color(0xFF1A1A1A)
private val NubankBigValueStrongColor = Color(0xFF191919)

val Colors.blue
    get() = NubankBlueColor

val Colors.strongText
get() = NubankBigValueStrongColor

val nubankColors = lightColors(
    primary = NubankPurple,
    surface = Color.White,
    onSurface = NubankSecondaryColor,
    onSecondary = NubankSecondaryTextColor
)

val BigValueTextStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    letterSpacing = 0.sp,
)

@Composable
fun NubankTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = nubankColors
    ) {
        content()
    }
}

@Composable
fun NuCard(
    icon: ImageVector,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        elevation = 3.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = icon.name,
                        tint = NubankSecondaryColor
                    )

                    Text(
                        text = title, style = MaterialTheme.typography.subtitle1,
                        color = NubankSecondaryColor
                    )
                }
                content()
            }

        }
    }
}

@Composable
fun ActionIcon(image: ImageVector, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .background(Color.White.copy(alpha = 0.3f), CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = image,
            contentDescription = image.name,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BottomCard(icon: ImageVector, title: String) {
    Column(
        modifier = Modifier
            .width(98.dp)
            .height(90.dp)
            .background(
                color = MaterialTheme.colors.surface.copy(alpha = 0.3f),
                shape = MaterialTheme.shapes.small
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(imageVector = icon, contentDescription = icon.name, tint = Color.White)

        Text(text = title, color = Color.White)
    }
}

@Preview
@Composable
fun PreviewActionIcon() {
    ActionIcon(image = Icons.Outlined.Add)
}

@Preview
@Composable
fun PreviewBottomCard() {
    BottomCard(icon = Icons.Outlined.Add, title = "Test")
}

@Preview
@Composable
fun PreviewNuCardCard() {
    NuCard(icon = Icons.Outlined.Money, title = "Test") {
        Text(text = "Test content")
    }
}