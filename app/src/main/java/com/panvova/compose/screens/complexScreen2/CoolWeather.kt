package com.panvova.compose.screens.complexScreen2

import android.graphics.Paint
import android.graphics.Rect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.panvova.compose.ui.theme.Orange

private var halfScreenWidth = 0f
private var radius = 0f

@Composable
@Preview(name = "Cool Weather", device = Devices.PIXEL, showSystemUi = true)
fun CoolWeather(){
  Circle()
  Title("142")
  Subtitle("US QAI")
  ThinCircle(0.40f)
  ThinCircle(0.45f)
  Arc(startAngle = 0f, endAngle = 240f, size = 500f, offset = 450f)
  Arc(startAngle = -90f, endAngle = 140f, size = 560f, offset = 480f)
}


@Composable
fun Circle() {
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    halfScreenWidth = size.width * 0.35f
    radius = halfScreenWidth - (halfScreenWidth * 0.25f)

    drawCircle(
      brush = Brush.radialGradient(listOf(Orange, Color.White)),
      radius = radius,
      center = size.center
    )
  })
}

@Composable
fun Title(titleName: String) {
  val offsetX = 10
  Canvas(modifier = Modifier
    .fillMaxSize(),
    onDraw = {
      drawContext.canvas.nativeCanvas.apply {
        val textRect = Rect()
        val paint = Paint().apply {
          textSize = radius * 0.70f
          color = android.graphics.Color.BLACK
          getTextBounds(titleName, 0, titleName.length, textRect)
        }

        val positionX = size.center.x - (textRect.width() / 2) - offsetX
        val positionY = size.center.y + (textRect.height() / 2)

        drawText(
          titleName,
          positionX,
          positionY,
          paint
        )
      }
    })
}

@Composable
fun Subtitle(subText: String) {
  val offsetY = 150
  Canvas(modifier = Modifier
    .fillMaxSize(),
    onDraw = {
      drawContext.canvas.nativeCanvas.apply {
        val text = subText
        val textRect = Rect()
        val paint = Paint().apply {
          textSize = radius * 0.15f
          color = android.graphics.Color.GRAY
          getTextBounds(text, 0, text.length, textRect)
        }

        val positionX = size.center.x - (textRect.width() / 2)
        val positionY = size.center.y + (textRect.height() / 2) + offsetY

        drawText(
          text,
          positionX,
          positionY,
          paint
        )
      }
    })
}

@Composable
fun ThinCircle(offset: Float) {
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    val halfScreenWidth = size.width * offset
    val radius = halfScreenWidth - (halfScreenWidth * 0.25f)

    drawCircle(
      color = Orange,
      style = Stroke(
        width = (radius * 0.005f)
      ),
      radius = radius,
      center = Offset(
        x = center.x,
        y = center.y
      )
    )
  })
}

@Composable
fun Arc(startAngle: Float, endAngle: Float, size: Float, offset: Float) {
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    drawArc(
      color = Orange,
      startAngle,
      endAngle,
      false,
      style = Stroke(width = 2f, cap = StrokeCap.Round),
      size = Size(halfScreenWidth + size, halfScreenWidth + size),
      topLeft = Offset(
        x = center.x - offset,
        y = center.y - offset
      )
    )
  })
}
