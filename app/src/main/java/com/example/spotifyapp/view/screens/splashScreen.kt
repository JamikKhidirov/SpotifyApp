package com.example.spotifyapp.view.screens

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spotifyapp.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay


@Composable
fun splashScreen(
    splash: () -> Unit
){
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(Unit) {
        delay(2000)
        splash()

    }

    DisposableEffect(Unit) {

        onDispose {
            systemUiController.setSystemBarsColor(
                color = androidx.compose.ui.graphics.Color(Color.BLACK)
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.splashvec),
            "",
            modifier = Modifier.width(200.dp).height(60.dp),
            contentScale = ContentScale.Crop)
    }
}