package com.example.valomate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valomate.data.remote.response.DataItem
import com.example.valomate.ui.theme.poppinsFontFamily

@Composable
fun CardAgentTwo(
    modifier: Modifier = Modifier,
    agents: DataItem
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = agents.displayIcon,
            contentDescription = "model"
        )
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
        ) {
            Text(
                text = agents.displayName,
                color = Color.White,
                fontFamily = poppinsFontFamily,
            )
            Text(
                text = agents.role.displayName,
                fontFamily = poppinsFontFamily,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

//@Preview(
//    showBackground = true,
//    backgroundColor = 0x0E1822,
//)
//@Composable
//private fun CardAgentTwoPreview() {
//    ValomateTheme(dynamicColor = false) {
//        CardAgentTwo(agents = null)
//    }
//}