package com.example.valomate.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.valomate.R
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.tungstenFamily

@Composable
fun CardAgent(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color("#c7f458ff".toColorInt()),
                        Color("#d56324ff".toColorInt()),
                        Color("#3a2656ff".toColorInt()),
                        Color("#3a7233ff".toColorInt()),
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .width(200.dp)
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.gecko),
            contentDescription = "Model",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .offset(y = (-75).dp) // Menggeser posisi gambar ke atas
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Gecko",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = tungstenFamily,
                fontSize = 40.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Initiator",
                color = Color.White,
                fontFamily = tungstenFamily,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
private fun CardAgentPreview() {
    ValomateTheme(dynamicColor = false) {
        CardAgent()
    }
}