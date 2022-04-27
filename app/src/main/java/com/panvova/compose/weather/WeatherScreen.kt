package com.panvova.compose.weather

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "Weather screen", device = Devices.PIXEL, showSystemUi = true)
@Composable
fun WeatherScreen() {
  WeatherList()
}

@Composable
fun WeatherList() {
  val weatherList = remember { WeatherProvider.weatherList }
  LazyColumn(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp)
  ) {
    items(
      items = weatherList,
      itemContent = {
        WeatherListItem(weather = it)
      })
  }
}