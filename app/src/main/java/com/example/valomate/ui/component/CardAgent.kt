package com.example.valomate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.example.valomate.data.remote.response.DataItem
import com.example.valomate.ui.theme.tungstenFamily

@Composable
fun CardAgent(
    modifier: Modifier = Modifier,
    agent: DataItem
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color("#${agent.backgroundGradientColors[0]}".toColorInt()),
                        Color("#${agent.backgroundGradientColors[1]}".toColorInt()),
                        Color("#${agent.backgroundGradientColors[2]}".toColorInt()),
                    )
                ),
                shape = RoundedCornerShape(20.dp)
            )
            .width(200.dp)
            .wrapContentHeight()
    ) {
        AsyncImage(
            model = agent.fullPortrait,
            contentDescription = "Model",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .offset(y = (-50).dp)
        )
        Text(
            text = agent.displayName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = tungstenFamily,
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}


//@Preview(
//    showBackground = true,
//)
//@Composable
//private fun CardAgentPreview() {
//    ValomateTheme(dynamicColor = false) {
//        CardAgent(
//            image = "",
//            name = "Gecko",
//            role = "Initiator",
//        )
//    }
//}