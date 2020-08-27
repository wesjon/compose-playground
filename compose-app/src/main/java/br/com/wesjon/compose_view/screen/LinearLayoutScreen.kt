package br.com.wesjon.compose_view.screen


import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
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
