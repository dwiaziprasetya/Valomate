package com.example.valomate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.valomate.R
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.tungstenFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValomateApp(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {},
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(start = 16.dp),
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(top = 16.dp),
                painter = painterResource(R.drawable.valorant_logo),
                contentDescription = "Logo"
            )
            Text(
                fontSize = 40.sp,
                text = "Choose Your",
                color = Color.White,
                fontFamily = tungstenFamily
            )
            Row {
                Text(
                    text = "Favourite ",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontFamily = tungstenFamily
                )
                Text(
                    text = "Agent",
                    color = Color("#FF5252".toColorInt()),
                    fontSize = 40.sp,
                    fontFamily = tungstenFamily
                )
            }
        }
    }
}

@Preview
@Composable
private fun ValomateAppPreview() {
    ValomateTheme(
        dynamicColor = false
    ) {
        ValomateApp()
    }
}