package com.example.spotifyapp.view.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyapp.R
import com.example.spotifyapp.view.componts.iconBtnTheme
import com.example.spotifyapp.view.componts.startedButton


@Composable
@Preview(showSystemUi = true)
fun chooseModeScreen(
    onClick: () -> Unit
){

    val white = Color.White.copy(0.1f)

    Image(painter = painterResource(R.drawable.gerl2),
        "", modifier = Modifier.fillMaxSize())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.splashvec),
            "",
            modifier = Modifier.padding(40.dp)
                .height(60.dp)
                .width(200.dp)
        )

        Text(
            text = "Выберите тему",
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = Bold,
            modifier = Modifier.padding(top = 300.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            iconBtnTheme(
                icon = R.drawable.moon,
                modifier = Modifier.padding(end = 20.dp)) {  }

            iconBtnTheme(
                icon = R.drawable.sun,
                text = "Светлая тема",
                modifier = Modifier.padding(start = 20.dp)
            ) {  }
        }


        startedButton(
            text = "Пропустить",
            modifier = Modifier.padding(top = 80.dp),
            onClick = onClick
        )
    }
}