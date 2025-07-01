package com.example.valomate.ui.navigation

sealed class Screen(val route: String){
    object Home : Screen("home")
    object Agents : Screen("agents")

    object DetailAgent : Screen("home/{agentsId}") {
        fun createRoute(agentsId: String) = "home/$agentsId"
    }
}