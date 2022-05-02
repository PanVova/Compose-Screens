package com.panvova.compose.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.panvova.compose.R.drawable
import com.panvova.compose.R.string
import com.panvova.compose.navigation.Screen.DetailsScreen
import com.panvova.compose.screens.weather.WeatherScreen

@Composable
fun MainScreen(navController: NavController) {
  Scaffold(
    topBar = { TopAppBar(navController) },
    content = {
      WeatherScreen()
    })
}

@Composable
fun TopAppBar(navController: NavController) {
  androidx.compose.material.TopAppBar(
    title = { Text(stringResource(string.weather_list)) },
    actions = {
      IconButton(onClick = { navController.navigate(DetailsScreen.route) }) {
        Icon(
          painter = painterResource(drawable.ic_launcher_foreground),
          contentDescription = null
        )
      }
    }
  )
}