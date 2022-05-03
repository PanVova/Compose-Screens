package com.panvova.compose.screens.details

import androidx.compose.material.SliderColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

class HappinessSliderImpl : SliderColors {

  private val disabledThumbColor = Color.Black
  private val thumbColor = Color.Green

  private val activeTrackColor = Color.Red
  private val inactiveTrackColor = Color.Black

  private val disabledActiveTrackColor = Color.Red
  private val disabledInactiveTrackColor = Color.Black

  @Composable
  override fun thumbColor(enabled: Boolean): State<Color> {
    return rememberUpdatedState(if (enabled) thumbColor else disabledThumbColor)
  }

  @Composable
  override fun trackColor(enabled: Boolean, active: Boolean): State<Color> {
    return rememberUpdatedState(
      if (enabled) {
        if (active) activeTrackColor else inactiveTrackColor
      } else {
        if (active) disabledActiveTrackColor else disabledInactiveTrackColor
      }
    )
  }

  @Composable
  override fun tickColor(enabled: Boolean, active: Boolean): State<Color> {
    return rememberUpdatedState(
      if (enabled) {
        if (active) activeTrackColor else inactiveTrackColor
      } else {
        if (active) disabledActiveTrackColor else disabledInactiveTrackColor
      }
    )
  }
}