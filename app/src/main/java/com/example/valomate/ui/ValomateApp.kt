package com.example.valomate.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.valomate.ui.detail.DetailScreen
import com.example.valomate.ui.home.HomeScreen
import com.example.valomate.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValomateApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold{ innerPadding ->
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
            composable(
                route = Screen.DetailAgent.route,
                arguments = listOf(navArgument("agentsId") { type = NavType.StringType })
            ){
                val uuid = it.arguments?.getString("agentsId") ?: ""
                DetailScreen (
                    uuid = uuid,
                    onBackClick = {
                        navController.navigateUp()
                    },
                )
            }
        }
   }
}