package com.example.valomate.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {

                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(start = 16.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
                Box(
                    modifier = Modifier
                        .height(600.dp)
                        .offset(
                            y = (-70).dp,
                            x = (-30).dp
                        )
                        .paint(
                            alignment = Alignment.CenterStart,
                            painter = painterResource(R.drawable.kayobackground),
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color("#FF5252".toColorInt()).copy(0.8f))
                        )
                )
                Image(
                    painter = painterResource(R.drawable.kayo),
                    contentDescription = "model",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(550.dp)
                        .offset(
                            x = (-50).dp,
                            y = (-60).dp
                        )
                )
                Text(
                    text = "KAY/O",
                    fontWeight = FontWeight.Bold,
                    fontSize = 90.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                            start = 32.dp,
                            end = 32.dp,
                            bottom = 32.dp
                        )
                        .align(Alignment.BottomEnd),
                    fontFamily = tungstenFamily
                )
            }
            Column {
                Text(
                    text = "Description",
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        DetailScreen()
    }
}