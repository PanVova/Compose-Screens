package com.panvova.compose.weather

data class Weather(
  val image: Int,
  val place: String,
  val minTemp: Int,
  val maxTemp: Int,
  val averageTemp: Int,
)