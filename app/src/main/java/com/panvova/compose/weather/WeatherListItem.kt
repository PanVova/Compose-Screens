package com.panvova.compose.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable
@Preview(name = "Preview3", device = Devices.PIXEL, showSystemUi = true)
fun WeatherListItem(@PreviewParameter(WeatherProvider::class) weather: Weather) {
  Row(modifier = Modifier.padding(top = 10.dp)) {
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
      Text(text = weather.place, style = typography.h6)
      Text(text = stringResource(string.minTemp, weather.minTemp), style = typography.caption)
      Text(text = stringResource(string.maxTemp, weather.maxTemp), style = typography.caption)
      Text(text = stringResource(string.averageTemp, weather.averageTemp), style = typography.caption)
    }
  }
}