package br.com.wesjon.compose_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.wesjon.compose_view.screen.GmailScreen
import br.com.wesjon.compose_view.screen.LinearLayoutScreen
import br.com.wesjon.compose_view.screen.ScrollableListScreen

class ComposeAppFragment : Fragment(R.layout.fragment_compose_app)

class ComposeDetailFragment : Fragment() {
    private val args by navArgs<ComposeDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ScaffoldScreen(title = args.composableRoute.title) {
                    when (args.composableRoute) {
                        ExampleLinearLayoutLike -> LinearLayoutScreen()
                        ExampleScrollableLists -> ScrollableListScreen()
                        GmailLikeLayout -> GmailScreen()
                    }
                }
            }
        }
    }
}