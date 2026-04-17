package com.example.valomate.ui.newdetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.valomate.R
import com.example.valomate.ui.theme.ValomateTheme

@Composable
fun NewDetailScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color(0XFFF6F4E8))
                .fillMaxSize()
                .weight(1f) ,
        ) {
            Image(
                painter = painterResource(R.drawable.kayo) ,
                contentDescription = null ,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .scale(2f)
                    .offset(x = 30.dp , y = 50.dp)
            )
        }
        Box (Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .weight(1f))
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun NewDetailScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        NewDetailScreen()
    }
}