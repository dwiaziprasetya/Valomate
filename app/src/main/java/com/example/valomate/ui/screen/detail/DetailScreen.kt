package com.example.valomate.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.valomate.R
import com.example.valomate.helper.ViewModelFactory
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.poppinsFontFamily
import com.example.valomate.ui.theme.tungstenFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    uuid: String,
    onBackClick: () -> Unit
){
    val viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(uuid = uuid)
    )

    val agent by viewModel.agent.observeAsState()

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
                        modifier = Modifier
                            .padding(
                                start = 24.dp,
                                top = 16.dp,
                            )
                            .drawBehind {
                                drawCircle(
                                    color = Color("#B4B4B8".toColorInt()),
                                    radius = size.minDimension / 1.1f,
                                    colorFilter = ColorFilter.tint(
                                        Color("#B4B4B8".toColorInt()).copy(
                                            0.4f
                                        )
                                    )
                                )
                            }
                            .clickable {
                                onBackClick()
                            },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .paint(
                    painter = painterResource(R.drawable.backgorund),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            if (agent?.data != null){
                Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
                    AsyncImage(
                        model = agent?.data?.background,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .height(600.dp)
                            .offset(
                                y = (-70).dp,
                                x = (-30).dp
                            ),
                        colorFilter = ColorFilter.tint(Color("#FF5252".toColorInt()).copy(0.8f))
                    )
                    AsyncImage(
                        model = agent?.data?.fullPortrait,
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
                        text = agent?.data?.displayName.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 90.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(
                                top = 32.dp,
                                start = 32.dp,
                                end = 32.dp,
                                bottom = 64.dp
                            )
                            .align(Alignment.BottomEnd),
                        fontFamily = tungstenFamily
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp)
                        .offset(y = (-64).dp)
                ) {
                    Text(
                        text = "Description",
                        color = Color("#FF5252".toColorInt()),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        fontFamily = poppinsFontFamily
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        fontSize = 13.sp,
                        text = agent?.data?.description.toString(),
                        color = Color.White,
                        fontFamily = poppinsFontFamily
                    )
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
}

@Preview
@Composable
private fun DetailScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        DetailScreen("uuid") {}
    }
}