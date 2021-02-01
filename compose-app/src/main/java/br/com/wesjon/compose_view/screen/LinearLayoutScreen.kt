package br.com.wesjon.compose_view.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Cyan)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxSize)
                .background(Color.Blue)
        )

        Box(
            modifier = Modifier
                .align(Alignment.End)
                .size(boxSize)
                .background(Color.Cyan)
        )
    }
}

@Composable
fun HorizontalExample() {
    Row {
        Spacer(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Cyan)
        )

        Spacer(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Blue)
        )

        Spacer(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Cyan)
        )
    }
}

@Preview
@Composable
fun WeighedViewsExample() {
    Row(modifier = Modifier.fillMaxWidth()) {
        WeightedBox(Color.Cyan, weight = 1, this)
        WeightedBox(Color.LightGray, weight = 2, this)
        WeightedBox(Color.Cyan, weight = 1, this)
    }
}

@Composable
fun WeightedBox(color: Color, weight: Int, rowScope: RowScope) {
    rowScope.apply {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(boxSize)
                .background(color)
                .weight(weight.toFloat()),
        ) {
            Text("Weight: $weight")
        }
    }
}
