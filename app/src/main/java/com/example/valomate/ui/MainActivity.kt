package com.example.valomate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.valomate.ui.theme.ValomateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValomateTheme(dynamicColor = false) {
                ValomateApp()
            }
        }
    }
}
