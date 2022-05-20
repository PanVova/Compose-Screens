package com.panvova.compose.screens.complexScreen5

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ComplexScreen5() {
  Box(modifier = Modifier.fillMaxSize()) {
    Text("This is complex screen 5", fontSize = 40.sp)
  }
}