package com.panvova.compose.screens.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.panvova.compose.R.string

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

@Composable
fun WeatherListItem(@PreviewParameter(WeatherProvider::class) weather: Weather) {
  var showDialog by remember { mutableStateOf(false) }
  val onPopupDismissed = { showDialog = false }

  Row(modifier = Modifier
    .padding(top = 10.dp)
    .clickable { showDialog = true }) {
    Image(
      painter = painterResource(id = weather.image),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .size(64.dp)
        .padding(bottom = 10.dp)
        .clip(CircleShape)
    )
    Column(
      modifier = Modifier.padding(start = 10.dp)
    ) {
      Text(text = weather.place, style = MaterialTheme.typography.h6)

      TemperatureText(stringResource(string.minTemp, weather.minTemp))
      TemperatureText(stringResource(string.maxTemp, weather.maxTemp))
      TemperatureText(stringResource(string.averageTemp, weather.averageTemp))
    }
  }

  if (showDialog) {
    AlertDialog(
      onDismissRequest = onPopupDismissed,
      text = {
        Text("Congratulations! You just clicked the text successfully")
      },
      confirmButton = {
        Button(onClick = onPopupDismissed) {
          Text(text = "Ok")
        }
      })
  }
}

@Composable
private fun TemperatureText(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.caption
  )
}