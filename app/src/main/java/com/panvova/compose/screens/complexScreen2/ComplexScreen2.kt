package com.panvova.compose.screens.complexScreen2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(name = "Complex screen 2", device = Devices.PIXEL, showSystemUi = true)
fun ComplexScreen2() {
  CoolWeather()
  OxygenList()
}

@Composable
fun OxygenList() {
  val oxygenList = remember { OxygenProvider.oxygenList }
  LazyRow(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
    verticalAlignment = Alignment.Bottom,
    horizontalArrangement = Arrangement.Center
  ) {
    items(
      items = oxygenList,
      itemContent = {
        OxygenListItem(oxygen = it)
      })
  }
}

