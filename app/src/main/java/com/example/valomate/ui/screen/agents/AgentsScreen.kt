package com.example.valomate.ui.screen.agents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.valomate.R
import com.example.valomate.ui.component.CardAgent
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentsScreen(
    navigateToDetail: (String) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.valorant_logo),
                            contentDescription = "",
                            tint = Color("#FF5252".toColorInt()),
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = "Agents",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                        )
                    }
                }
            )
        }
    ) {
        val viewModel: AgentsViewModel = viewModel()

        val agents by viewModel.agents.observeAsState()

        if (agents != null){
            LazyVerticalGrid(
                modifier = Modifier.padding(it),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(agents?.data ?: emptyList()) { agent ->
                    if(agent.isPlayableCharacter){
                        CardAgent(
                            agent = agent,
                            modifier = Modifier
                                .clickable {
                                    navigateToDetail(agent.uuid)
                                }
                        )
                    }
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color("#FF5252".toColorInt())
                )
            }
        }
    }
}

@Preview
@Composable
private fun AgentsScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        AgentsScreen {}
    }
}