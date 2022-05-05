package com.panvova.compose.screens.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.panvova.compose.R.string
import com.panvova.compose.navigation.Screen.ComplexScreen1
import com.panvova.compose.navigation.Screen.ComplexScreen2
import com.panvova.compose.navigation.Screen.ComplexScreen3
import com.panvova.compose.navigation.Screen.ComplexScreen4
import com.panvova.compose.navigation.Screen.ComplexScreen5
import com.panvova.compose.navigation.Screen.DetailsScreen
import com.panvova.compose.screens.weather.WeatherScreen

var selectedIndex = mutableStateOf(0)

@Composable
fun MainScreen(navController: NavController) {
  Scaffold(
    topBar = { TopAppBar(navController) },
    bottomBar = { BottomAppBar() },
    content = {
      WeatherScreen()
    })
}

@Composable
fun TopAppBar(navController: NavController) {
  androidx.compose.material.TopAppBar(
    title = { Text(stringResource(string.weather_list)) },
    actions = {
      for (index in 0..5) {
        val (icon, route) = when (index) {
          0 -> Pair(Icons.Filled.Info, DetailsScreen.route)
          1 -> Pair(Icons.Filled.Face, ComplexScreen1.route)
          2 -> Pair(Icons.Filled.Home, ComplexScreen2.route)
          3 -> Pair(Icons.Filled.ThumbUp, ComplexScreen3.route)
          4 -> Pair(Icons.Filled.KeyboardArrowUp, ComplexScreen4.route)
          5 -> Pair(Icons.Filled.Send, ComplexScreen5.route)
          else -> Pair(Icons.Filled.Info, DetailsScreen.route)
        }

        IconButton(onClick = { navController.navigate(route) }) {
          Icon(icon, contentDescription = null)
        }
      }
    }
  )
}

@Composable
fun BottomAppBar() {
  BottomNavigation() {
    for (i in 0..3) {

      val (imageVector, name) = when (i) {
        0 -> Pair(Icons.Filled.Favorite, "Favorite")
        1 -> Pair(Icons.Filled.Build, "Build")
        2 -> Pair(Icons.Filled.Call, "Call")
        else -> Pair(Icons.Filled.Email, "Email")
      }

      BottomNavigationItem(
        icon = {
          Icon(imageVector = imageVector, contentDescription = null)
        },
        label = {
          Text(text = name)
        },
        selected = selectedIndex.value == i,
        onClick = { selectedIndex.value = i },
        selectedContentColor = Color.Green,
        unselectedContentColor = Color.White
      )
    }
  }
}
