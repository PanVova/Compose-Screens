package com.panvova.compose.screens.complexScreen1

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(name = "Complex screen 1", device = Devices.PIXEL, showSystemUi = true)
fun ComplexScreen1() {
  CircularProgressIndicator(progress = 10.0F)
}