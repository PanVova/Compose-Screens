package com.panvova.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.panvova.compose.R.string
import com.panvova.compose.ui.theme.ComposeTheme
import com.panvova.compose.weather.WeatherScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          ScaffoldWithTopBar()
        }
      }
    }
  }
}

@Composable
fun ScaffoldWithTopBar() {
  Scaffold(
    topBar = { TopAppBar() },
    content = {
      WeatherScreen()
    })
}

@Composable
fun TopAppBar() {
  TopAppBar(
    title = { Text(stringResource(string.weather_list)) },
    actions = {
      Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
    }
  )
}