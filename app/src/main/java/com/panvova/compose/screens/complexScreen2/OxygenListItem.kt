package com.panvova.compose.screens.complexScreen2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OxygenListItem(@PreviewParameter(OxygenProvider::class) oxygen: Oxygen) {

  val borderColor = when {
    oxygen.oxygen < 1.0F -> Color.Red
    oxygen.oxygen in 1.0F..5.0F -> Color.Yellow
    oxygen.oxygen > 5.0F -> Color.Green
    else -> Color.Green
  }

  Column {
    Text(oxygen.title, modifier = Modifier.padding(start = 38.dp))

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier
      .padding(start = 10.dp)
      .background(color = Color.Black, shape = CircleShape)
      .border(BorderStroke(1.dp, borderColor), shape = CircleShape)
      .layout() { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val currentHeight = placeable.height
        var heightCircle = currentHeight
        if (placeable.width > heightCircle) heightCircle = placeable.width

        layout(heightCircle, heightCircle) {
          placeable.placeRelative(0, (heightCircle - currentHeight) / 2)
        }
      }) {

      Text(
        text = oxygen.oxygen.toString(),
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        color = Color.White,
        modifier = Modifier
          .padding(bottom = 24.dp)
      )

      Text(
        text = oxygen.subtitle,
        textAlign = TextAlign.Center,
        color = Color.Gray,
        modifier = Modifier
          .padding(4.dp, bottom = 4.dp)
          .defaultMinSize(72.dp)
      )
    }
  }
}