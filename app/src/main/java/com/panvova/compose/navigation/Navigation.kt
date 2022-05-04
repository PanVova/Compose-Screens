package com.panvova.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.panvova.compose.screens.complexScreen1.ComplexScreen1
import com.panvova.compose.screens.complexScreen2.ComplexScreen2
import com.panvova.compose.screens.details.DetailsScreen
import com.panvova.compose.screens.main.MainScreen

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
    composable(route = Screen.ComplexScreen1.route) {
      ComplexScreen1()
    }
    composable(route = Screen.ComplexScreen2.route) {
      ComplexScreen2()
    }
  }
}