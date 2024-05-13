package com.example.valomate.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.valomate.R
import com.example.valomate.ui.navigation.NavigationItem
import com.example.valomate.ui.navigation.Screen
import com.example.valomate.ui.theme.ValomateTheme
import com.example.valomate.ui.theme.poppinsFontFamily

@Composable
fun BottomNavigation(
    navController: NavController
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .height(78.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = painterResource(R.drawable.homeoutlined),
                iconActive = painterResource(R.drawable.homefilled),
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Agent",
                icon = painterResource(R.drawable.swordoutlined),
                iconActive = painterResource(R.drawable.swordfilled),
                screen = Screen.Agents
            ),
            NavigationItem(
                title = "About",
                icon = painterResource(R.drawable.accountcircleoutlined),
                iconActive = painterResource(R.drawable.accountcirclefilled),
                screen = Screen.About
            ),
        )
        navigationItems.map { item ->
            val isSelected = currentRoute == item.screen.route
            NavigationBarItem(
                label = {
                    if (isSelected) {
                        Text(
                            text = item.title,
                            fontFamily = poppinsFontFamily,
                            color = Color("#FF5252".toColorInt())
                        )
                    } else {
                        Text(
                            text = item.title,
                            fontFamily = poppinsFontFamily,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                },
                selected = isSelected,
                icon = {
                    if (isSelected) {
                        Icon(
                            painter = item.iconActive,
                            contentDescription = item.title,
                            tint = Color("#FF5252".toColorInt())
                        )
                    } else {
                        Icon(
                            painter = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background
                ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    ValomateTheme(dynamicColor = false) {
        BottomNavigation(rememberNavController())
    }
}