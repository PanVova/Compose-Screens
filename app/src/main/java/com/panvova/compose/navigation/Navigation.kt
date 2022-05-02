package com.panvova.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.panvova.compose.screens.main.MainScreen
import com.panvova.compose.screens.details.DetailsScreen

@Composable
fun Navigation() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
    composable(route = Screen.MainScreen.route) {
      MainScreen(navController)
    }
    composable(route = Screen.DetailsScreen.route) {
      DetailsScreen()
    }
  }
}