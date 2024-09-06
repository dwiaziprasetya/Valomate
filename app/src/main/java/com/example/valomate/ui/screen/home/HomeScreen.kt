package com.example.valomate.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.valomate.R
import com.example.valomate.ui.component.CardAgent
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.tungstenFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToDetail: (String) -> Unit
){
    val viewModel : HomeViewModel = viewModel()

    val agents by viewModel.agents.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {},
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .paint(
                    painter = painterResource(R.drawable.backgorund),
                    contentScale = ContentScale.FillBounds
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.valorant_logo),
                contentDescription = "Logo"
            )
            Text(
                fontSize = 39.sp,
                text = "Choose Your",
                color = Color.White,
                fontFamily = tungstenFamily
            )
            Row(modifier = Modifier.padding(bottom = 24.dp)) {
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
            if (agents?.data != null) {
                LazyRow(
                    modifier = Modifier
                        .padding(top = 64.dp),
                ) {
                    items(agents?.data ?: emptyList()) { agent ->
                        if (agent.isPlayableCharacter){
                            CardAgent(
                                agent = agent,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .clickable {
                                        navigateToDetail(agent.uuid)
                                    },
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize()){
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Color("#FF5252".toColorInt())
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        HomeScreen{}
    }
}