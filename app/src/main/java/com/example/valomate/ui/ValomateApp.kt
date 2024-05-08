package com.example.valomate.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.valomate.ui.component.BottomNavigation
import com.example.valomate.ui.navigation.Screen
import com.example.valomate.ui.screen.about.AboutScreen
import com.example.valomate.ui.screen.agents.AgentsScreen
import com.example.valomate.ui.screen.detail.DetailScreen
import com.example.valomate.ui.screen.home.HomeScreen
import com.example.valomate.ui.theme.ValomateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValomateApp(
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailAgent.route) {
                BottomNavigation(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = Screen.Home.route,){
                HomeScreen(
                    navigateToDetail = { uuid ->
                        navController.navigate(Screen.DetailAgent.createRoute(uuid))
                    }
                )
            }
            composable(route = Screen.Agents.route){
                AgentsScreen()
            }
            composable(route = Screen.About.route){
                AboutScreen()
            }
            composable(
                route = Screen.DetailAgent.route,
                arguments = listOf(navArgument("agentsId") { type = NavType.StringType })
            ){
                val uuid = it.arguments?.getString("agentsId") ?: ""
                DetailScreen(
                    uuid = uuid,
                    onBackClick = {
                        navController.navigateUp()
                    },
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