package com.panvova.compose.screens.complexScreen3

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panvova.compose.R
import com.panvova.compose.R.string
import com.panvova.compose.ui.theme.DimGray

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview(name = "Complex screen 3", device = Devices.PIXEL, showSystemUi = true)
fun ComplexScreen3() {

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(DimGray)
      .padding(top = 100.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Text(stringResource(string.ride_complete), fontSize = 28.sp, paddingBottom = 10.dp)
    Text(stringResource(string.please_rate_ride), fontSize = 16.sp, paddingBottom = 60.dp)

    Image(
      painter = painterResource(R.drawable.ic_avatar),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .size(240.dp)
        .clip(CircleShape)
        .border(width = 10.dp, color = Color.Blue, CircleShape)
    )

    Text(
      text = stringResource(string.tom_holland),
      fontSize = 22.sp,
      modifier = Modifier.padding(top = 30.dp)
    )

    RatingBar(rating = 4)

    TextFieldWithIcon()

    Button(
      onClick = { },
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 60.dp, end = 60.dp),
      colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
    ) {
      Text("Submit feedback", color = Color.White)
    }

    TextButton(onClick = { }) {
      Text("Skip feedback", color = Color.White)
    }

  }

  OuterCircle()
}

@Composable
fun Text(text: String, paddingBottom: Dp = 0.dp, fontSize: TextUnit) {
  Text(
    text = text,
    fontSize = fontSize,
    modifier = Modifier.padding(bottom = paddingBottom)
  )
}

@Composable
fun OuterCircle() {
  Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
    val halfScreenWidth = size.width * 0.45f
    val radius = halfScreenWidth - (halfScreenWidth * 0.25f)

    drawCircle(
      color = Color.Blue,
      style = Stroke(
        width = (radius * 0.01f)
      ),
      radius = radius,
      center = Offset(
        x = center.x,
        y = center.y - 150F
      )
    )
  })
}

@ExperimentalComposeUiApi
@Composable
fun RatingBar(
  modifier: Modifier = Modifier,
  rating: Int
) {
  var ratingState by remember { mutableStateOf(rating) }
  val size by remember { mutableStateOf(32.dp) }

  Row(
    verticalAlignment = Alignment.Bottom,
    horizontalArrangement = Arrangement.Center
  ) {
    for (i in 1..5) {
      Icon(
        Icons.Filled.Star,
        contentDescription = null,
        modifier = modifier
          .width(size)
          .height(size)
          .pointerInteropFilter {
            if (it.action == MotionEvent.ACTION_DOWN) ratingState = i
            true
          },
        tint = if (i <= ratingState) Color.Yellow else Color.Gray
      )
    }
  }
}

@Composable
fun TextFieldWithIcon() {
  var text by remember { mutableStateOf(TextFieldValue("")) }
  OutlinedTextField(
    value = text,
    leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
    onValueChange = { text = it },
    label = { Text(stringResource(string.leave_feedback)) },
    placeholder = { Text(stringResource(string.leave_feedback)) },
    modifier = Modifier.padding(top = 40.dp, bottom = 40.dp)
  )
}