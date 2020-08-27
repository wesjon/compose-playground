package br.com.wesjon.compose_view.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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