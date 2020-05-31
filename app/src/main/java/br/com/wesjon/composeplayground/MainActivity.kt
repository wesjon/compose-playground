package br.com.wesjon.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Providers
import androidx.ui.core.setContent
import br.com.wesjon.compose_view.ComposeApp
import br.com.wesjon.compose_view.Routing
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler

class MainActivity : AppCompatActivity() {
    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            Providers(
                AmbientBackPressHandler provides backPressHandler
            ) {
                ComposeApp(Routing.HomeScreen)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (!backPressHandler.handle()) {
            super.onBackPressed()
        }
    }
}