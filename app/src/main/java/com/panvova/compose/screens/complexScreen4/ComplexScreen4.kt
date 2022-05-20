package com.panvova.compose.screens.complexScreen4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.panvova.compose.R
import com.panvova.compose.R.string

@Composable
@Preview(name = "Complex screen 4", device = Devices.PIXEL, showSystemUi = true)
fun ComplexScreen4() {
  ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    // list of all views in screen
    val (
      menuButton, coverImage, titleText, genreText,
      ratingText, castText, castContainer, castImage1,
      castImage2, castImage3, castImage4, descText,
    ) = createRefs()

    Icon(
      imageVector = Icons.Filled.Done,
      contentDescription = null,
      modifier = Modifier
        .size(48.dp)
        .padding(8.dp)
        .constrainAs(menuButton) {
          start.linkTo(parent.start, 16.dp)
          top.linkTo(parent.top, 16.dp)
        }
    )

    val rightGuideline = createGuidelineFromStart(0.4f)

    Image(
      imageVector = Icons.Filled.Home,
      contentDescription = null,
      contentScale = ContentScale.Crop,
      alignment = Alignment.Center,
      modifier = Modifier
        .constrainAs(coverImage) {
          start.linkTo(parent.start, 24.dp)
          top.linkTo(menuButton.bottom, 16.dp)
          end.linkTo(rightGuideline, 16.dp)
          width = Dimension.fillToConstraints
        }
        .aspectRatio(2f / 3f),
    )

    Text(
      text = stringResource(string.movie_name),
      style = MaterialTheme.typography.h4,
      fontWeight = FontWeight.SemiBold,
      modifier = Modifier.constrainAs(titleText) {
        top.linkTo(menuButton.bottom, 8.dp)
        start.linkTo(coverImage.end, 16.dp)
      }
    )

    Text(
      text = stringResource(string.movie_duration),
      fontSize = 16.sp,
      color = Color.Gray,
      modifier = Modifier.constrainAs(genreText) {
        top.linkTo(titleText.bottom)
        start.linkTo(coverImage.end, 16.dp)
      }
    )

    Text(
      text = stringResource(string.movie_rate),
      fontWeight = FontWeight.Medium,
      style = MaterialTheme.typography.body1,
      modifier = Modifier.constrainAs(ratingText) {
        top.linkTo(genreText.bottom, 16.dp)
        start.linkTo(coverImage.end, 16.dp)
      }
    )

    Text(
      text = stringResource(string.movie_cast),
      fontSize = 14.sp,
      color = Color.Gray,
      fontWeight = FontWeight.SemiBold,
      modifier = Modifier.constrainAs(castText) {
        bottom.linkTo(castContainer.top)
        start.linkTo(coverImage.end, 16.dp)
      }
    )

    ConstraintLayout(modifier = Modifier.constrainAs(castContainer) {
      bottom.linkTo(coverImage.bottom)
      start.linkTo(coverImage.end, 16.dp)
      end.linkTo(parent.end, 16.dp)
      width = Dimension.fillToConstraints
    })
    {
      Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .height(50.dp)
          .constrainAs(castImage1) {
            bottom.linkTo(coverImage.bottom)
            start.linkTo(coverImage.end, 16.dp)
          }
          .aspectRatio(1f)
      )

      Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .height(50.dp)
          .constrainAs(castImage2) {
            top.linkTo(castImage1.top)
            bottom.linkTo(castImage1.bottom)
            start.linkTo(castImage1.end)
          }
          .aspectRatio(1f)
      )

      Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .height(50.dp)
          .constrainAs(castImage3) {
            top.linkTo(castImage1.top)
            bottom.linkTo(castImage1.bottom)
            start.linkTo(castImage2.end)
          }
          .aspectRatio(1f)
      )

      Box(modifier = Modifier
        .height(50.dp)
        .background(Color.Gray)
        .constrainAs(castImage4) {
          top.linkTo(castImage1.top)
          bottom.linkTo(castImage1.bottom)
          start.linkTo(castImage3.end)
          end.linkTo(parent.end, 16.dp)
        }
        .aspectRatio(1f)) {
        Text(
          text = "+9",
          textAlign = TextAlign.Center,
          fontSize = 14.sp,
          modifier = Modifier
            .padding(horizontal = 4.dp)
            .align(Alignment.Center),
          color = Color.Black
        )
      }

      createHorizontalChain(
        castImage1, castImage2, castImage3, castImage4,
        chainStyle = ChainStyle.SpreadInside
      )
    }

    val barrier = createBottomBarrier(coverImage, castContainer)

    Text(
      text = stringResource(string.movie_info),
      color = Color(0x8A000000),
      fontSize = 16.sp,
      modifier = Modifier.constrainAs(descText) {
        top.linkTo(barrier, 36.dp)
        start.linkTo(parent.start, 24.dp)
        end.linkTo(parent.end, 24.dp)
        width = Dimension.preferredWrapContent
      }
    )
  }
}