package com.panvova.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.panvova.compose.screens.complexScreen1.ComplexScreen1
import com.panvova.compose.screens.complexScreen2.ComplexScreen2
import com.panvova.compose.screens.complexScreen3.ComplexScreen3
import com.panvova.compose.screens.complexScreen4.ComplexScreen4
import com.panvova.compose.screens.complexScreen5.ComplexScreen5
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
    composable(route = Screen.ComplexScreen3.route) {
      ComplexScreen3()
    }
    composable(route = Screen.ComplexScreen4.route) {
      ComplexScreen4()
    }
    composable(route = Screen.ComplexScreen5.route) {
      ComplexScreen5()
    }
  }
}