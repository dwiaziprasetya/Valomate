package com.example.valomate.ui.screen.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.valomate.ui.theme.ValomateTheme

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "About Screen",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun AboutScreenPreview() {
    ValomateTheme {
        AboutScreen()
    }
}