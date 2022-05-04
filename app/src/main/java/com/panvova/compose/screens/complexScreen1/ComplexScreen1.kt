package com.panvova.compose.screens.complexScreen1

import android.graphics.Paint
import android.graphics.Rect
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.cos
import kotlin.math.sin

private var halfScreenWidth = 0f
private var radius = 0f
private var numberOfDots = 40
private var isActive = mutableStateOf(false)

@Composable
@Preview(name = "Complex screen 1", device = Devices.PIXEL, showSystemUi = true)
fun ComplexScreen1() {
  Circle()
  Dots()
  TitleState()
}

@Composable
fun Circle() {
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    halfScreenWidth = size.width * 0.5f
    radius = halfScreenWidth - (halfScreenWidth * 0.25f)
    // we used second as a padding

    drawCircle(
      color = Color.Gray,
      style = Stroke(
        width = (radius * 0.1f)
      ),
      radius = radius,
      center = size.center
    )
  })
}

@Composable
fun Dots() {
  // angle distance between each dot
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    val lineDegree = 360f / numberOfDots

    for (dotNumber in 0..numberOfDots) {
      val angleInDegrees = lineDegree * dotNumber - 90f
      val angleRadians = Math.toRadians(angleInDegrees.toDouble()).toFloat() // convert to radians
      val dotDistanceFromMainCircle = radius * 0.15f
      val dotRadius = radius * 0.015f

      drawCircle(
        center = Offset(
          x = (radius + dotDistanceFromMainCircle) * cos(angleRadians) + size.center.x,
          y = (radius + dotDistanceFromMainCircle) * sin(angleRadians) + size.center.y
        ),
        color = if (isActive.value) Color.Green else Color.Red,
        radius = dotRadius
      )
    }
  })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TitleState() {
  Canvas(modifier = Modifier
    .fillMaxSize()
    .pointerInteropFilter {
      when (it.action) {
        MotionEvent.ACTION_DOWN -> isActive.value = !isActive.value
        else -> false
      }
      true
    }, onDraw = {
    drawContext.canvas.nativeCanvas.apply {
      val text = if (isActive.value) "ON" else "OFF"
      val textRect = Rect()
      val paint = Paint().apply {
        textSize = radius * 0.15f
        color = if (isActive.value) android.graphics.Color.GREEN else android.graphics.Color.RED
        getTextBounds(text, 0, text.length, textRect)
      }

      val positionX = size.center.x - (textRect.width() / 2)
      val positionY = size.center.y + (textRect.height() / 2)

      drawText(
        text,
        positionX,
        positionY,
        paint
      )
    }
  })
}