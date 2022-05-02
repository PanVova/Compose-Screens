package com.panvova.compose.screens.weather

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.panvova.compose.R.drawable

object WeatherProvider : PreviewParameterProvider<Weather> {

  val weatherList = listOf(
    Weather(drawable.ic_launcher_background, "Chicago", 10, 20, 15),
    Weather(drawable.ic_launcher_background, "London", -5, 10, 8),
    Weather(drawable.ic_launcher_background, "Kyiv", 5, 10, 7)
  )
  override val values: Sequence<Weather>
    get() = weatherList.asSequence()
}