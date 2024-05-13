package com.example.valomate.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
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
import com.example.valomate.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
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
                            text = "Profile",
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
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.drawable.backgorund),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    )
            ) {
                Row{
                    Image(
                        painter = painterResource(R.drawable.dwiaziprasetya2),
                        contentDescription = "model",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .border(
                                width = 2.dp,
                                color = Color("#FF5252".toColorInt()),
                                shape = CircleShape
                            )
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp)
                    ) {
                        Text(
                            text = "Dwi Azi Prasetya",
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "dwiaziprasetya \uD83E\uDDD1\u200D\uD83D\uDCBB",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.outline,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.universityicon),
                        contentDescription = "University",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "Diponegoro Univeristy - Fisika",
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp),
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "dwiaziprasetya456@gmail.com",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp),
                        fontFamily = poppinsFontFamily
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.linkedinicon),
                        contentDescription = "Linked-in",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "in/dwiaziprasetya",
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp),
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.instagramicon),
                        contentDescription = "Instagram",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "dwi.azii",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp),
                        fontFamily = poppinsFontFamily
                    )
                }
                Text(
                    text = "Description",
                    color = Color("#FF5252".toColorInt()),
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 32.dp)
                )
                Text(
                    text = """
                        Hello, my name is Dwi Azi Prasetya, I am a Physics student from Semarang, Central Java, currently studying at Diponegoro University. Despite being a Physics student, his deep interest in Informatics, especially in the field of Software Engineering on mobile application development, makes me never stop learning and exploring new knowledge. With his tireless spirit, I am determined to become a professional who is able to unite his love for science and technology in creating innovative solutions for the future.
                    """.trimIndent(),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AboutScreenPreview() {
    ValomateTheme(dynamicColor = false) {
        AboutScreen()
    }
}