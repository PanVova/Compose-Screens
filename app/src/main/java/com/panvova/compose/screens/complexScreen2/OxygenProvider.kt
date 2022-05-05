package com.panvova.compose.screens.complexScreen2

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

object OxygenProvider : PreviewParameterProvider<Oxygen> {

  val oxygenList = listOf(
    Oxygen(title = "PM", subtitle = "umx", oxygen = 11.2f),
    Oxygen(title = "CO", subtitle = "ppb", oxygen = 0.5f),
    Oxygen(title = "SO", subtitle = "aam", oxygen = 10.0f),
    Oxygen(title = "AK", subtitle = "ark", oxygen = 5.0f)

  )

  override val values: Sequence<Oxygen>
    get() = oxygenList.asSequence()
}