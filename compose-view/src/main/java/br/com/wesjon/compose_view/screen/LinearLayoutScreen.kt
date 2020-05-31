package br.com.wesjon.compose_view.screen

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.layout.RowScope.weight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import br.com.wesjon.compose_view.view.ExampleWithTitle

private val boxSize = 40.dp

@Preview
@Composable
fun LinearLayoutScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        ExampleWithTitle("Vertical") { VerticalExample() }
        ExampleWithTitle("Horizontal") { HorizontalExample() }
        ExampleWithTitle("Weighted") { WeighedViewsExample() }
    }
}

@Composable
fun VerticalExample() {
    Column(
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        Box(
            backgroundColor = Color.Cyan,
            modifier = Modifier.size(boxSize)
        )

        Box(
            backgroundColor = Color.Blue,
            modifier = Modifier.fillMaxWidth() + Modifier.height(boxSize)
        )

        Box(
            backgroundColor = Color.Cyan,
            modifier = Modifier.gravity(Alignment.End) + Modifier.size(boxSize)
        )
    }
}

@Preview
@Composable
fun HorizontalExample() {
    Row {
        Box(
            backgroundColor = Color.Cyan,
            modifier = Modifier.size(boxSize)
        )

        Box(
            backgroundColor = Color.Blue,
            modifier = Modifier.size(boxSize)
        )

        Box(
            backgroundColor = Color.Cyan,
            modifier = Modifier.size(boxSize)
        )
    }
}

@Preview
@Composable
fun WeighedViewsExample() {
    Row(modifier = Modifier.fillMaxWidth()) {
        WeightedBox(Color.Cyan, weight = 1)
        WeightedBox(Color.LightGray, weight = 2)
        WeightedBox(Color.Cyan, weight = 1)
    }
}

@Composable
fun WeightedBox(color: Color, weight: Int) {
    Box(
        backgroundColor = color,
        gravity = ContentGravity.Center,
        modifier = Modifier.weight(weight = weight.toFloat()) + Modifier.height(boxSize)
    ) {
        Text("Weight: $weight")
    }
}
