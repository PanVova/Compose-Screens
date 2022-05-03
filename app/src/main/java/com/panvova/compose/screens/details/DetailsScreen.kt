package com.panvova.compose.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Slider
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.panvova.compose.R.string
import com.panvova.compose.screens.weather.WeatherListItem
import com.panvova.compose.screens.weather.WeatherProvider
import kotlinx.coroutines.launch

@Composable
@Preview(name = "Details screen", device = Devices.PIXEL, showSystemUi = true)
fun DetailsScreen() {
  Column(
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()
  ) {
    QuestionTitle()
    RadioButtons()
    HappinessSlider()
    PrettyButton()
    Carousel()
  }
}

@Composable
fun QuestionTitle() {
  Text(stringResource(string.question_favourite_superhero))
}

@Composable
fun RadioButtons() {
  var selected by remember { mutableStateOf("Superman") }
  val firstChoice = "Superman"
  val secondChoice = "Batman"
  Column {

    Row(modifier = Modifier.clickable(onClick = { selected = firstChoice })) {
      RadioButton(selected = selected == firstChoice, onClick = { selected = firstChoice })
      Text(
        text = firstChoice,
        modifier = Modifier
          .padding(start = 4.dp)
      )
    }

    Spacer(modifier = Modifier.size(4.dp))

    Row(modifier = Modifier.clickable(onClick = { selected = secondChoice })) {
      RadioButton(selected = selected == secondChoice, onClick = { selected = secondChoice })
      Text(
        text = secondChoice,
        modifier = Modifier.padding(start = 4.dp)
      )
    }
  }
}

@Composable
fun HappinessSlider() {
  var selected by remember { mutableStateOf(10.00F) }
  val happinessColors = HappinessSliderImpl()

  Slider(
    value = selected,
    onValueChange = { value -> selected = value },
    colors = happinessColors,
    modifier = Modifier.width(200.dp)
  )

  Text(stringResource(string.current_happiness))
}

@Composable
fun PrettyButton() {
  val snackbarHostState = remember { SnackbarHostState() }
  val coroutineScope = rememberCoroutineScope()
  OutlinedButton(onClick = {
    coroutineScope.launch {
      snackbarHostState.showSnackbar(message = "This is a Snackbar")
    }
  }) {
    Text("Click on me")
  }

  SnackbarHost(hostState = snackbarHostState)
}


@Composable
fun Carousel() {
  val weatherList = remember { WeatherProvider.weatherList }
  LazyRow(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp)
  ) {
    items(
      items = weatherList,
      itemContent = {
        WeatherListItem(weather = it)
      })
  }
}