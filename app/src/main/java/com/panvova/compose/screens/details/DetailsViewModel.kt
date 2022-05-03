package com.panvova.compose.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DetailsViewModel: ViewModel() {

  var selectedChoice by mutableStateOf("Male")

}