package com.panvova.compose.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.panvova.compose.R.string
import com.panvova.compose.ui.theme.Typography

@Preview(name = "Weather screen", device = Devices.PIXEL, showSystemUi = true)
@Composable
fun WeatherScreen() {
  Title()
  WeatherList()
}

@Composable
fun Title() {
  Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.padding(top = 10.dp)) {
    Text(stringResource(string.weather_list), style = Typography.h5)
  }
}

@Composable
fun WeatherList() {
  val weatherList = remember { WeatherProvider.weatherList }
  LazyColumn(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 50.dp)
  ) {
    items(
      items = weatherList,
      itemContent = {
        WeatherListItem(weather = it)
      })
  }
}