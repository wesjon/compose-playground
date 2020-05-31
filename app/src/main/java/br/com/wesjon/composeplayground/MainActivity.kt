package br.com.wesjon.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import br.com.wesjon.compose_view.ComposeApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            ComposeApp()
        }
    }
}