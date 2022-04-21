package br.com.wesjon.compose_view.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.wesjon.compose_view.ScaffoldScreen
import br.com.wesjon.compose_view.model.Example

class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ScaffoldScreen(title = "Home app") {
                    HomeScreen {
                        val action = HomeScreenFragmentDirections.actionGoToExampleDetail(it)
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreen(onExampleClicked: (Example) -> Unit) {
    MaterialTheme {
        Box(Modifier.background(MaterialTheme.colors.background)) {
            ExamplesList(onExampleClicked)
        }
    }
}

@Composable
fun ExamplesList(onExampleClicked: (Example) -> Unit) {
    LazyColumn(modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)) {
        items(count = Example.values().size,
            itemContent = {
                ExampleListItem(Example.values()[it], onExampleClicked)
            })
    }
}

@Composable
fun ExampleListItem(
    example: Example,
    onExampleClicked: (Example) -> Unit
) {
    Button(
        onClick = { onExampleClicked.invoke(example) },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 0.dp, 8.dp, 16.dp),
        enabled = example.isImplemented
    ) {
        Text(text = example.title)
    }
}