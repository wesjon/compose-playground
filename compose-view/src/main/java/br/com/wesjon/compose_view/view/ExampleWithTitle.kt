package br.com.wesjon.compose_view.view

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope
import androidx.ui.layout.Spacer
import androidx.ui.layout.height
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp

@Composable
fun ExampleWithTitle(
    title: String,
    children: @Composable() ColumnScope.() -> Unit
) {
    Column {
        Text(
            style = MaterialTheme.typography.h5,
            text = title
        )

        ColumnScope.children()

        Spacer(modifier = Modifier.height(16.dp))
    }
}