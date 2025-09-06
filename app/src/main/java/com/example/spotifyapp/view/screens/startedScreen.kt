package com.example.spotifyapp.view.screens


import android.graphics.Color
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyapp.R
import com.example.spotifyapp.view.componts.startedButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Preview(showSystemUi = true)
@Composable
fun startedScreen(
    onClick: () -> Unit = {}
){
    val systemUiController = rememberSystemUiController()

    val black = colorResource(R.color.black)

    systemUiController.setSystemBarsColor(
        color = black
    )
    Image(painter = painterResource(R.drawable.gerl),
        "", modifier = Modifier.fillMaxSize())
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.splashvec),
            "",
            modifier = Modifier
                .padding(top = 37.dp)
                .height(60.dp)
                .width(200.dp))


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 370.dp)
        ){
            Text("Наслаждайтесь прослушиванием музыки",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = androidx.compose.ui.graphics.Color(Color.WHITE),
                modifier = Modifier)
        }


        Text(
            text = "Благодарим вас за проявленный интерес к нашей компании и добро пожаловать в нашу компанию. Чистый, но улучшенный вариант для посетителей. Я должен как-то поступить в старшую школу.",
            fontSize = 17.sp,
            color = colorResource(R.color.graytext),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(17.dp).padding(horizontal = 10.dp).alpha(0.7f)
        )

        startedButton(
            modifier = Modifier.padding(25.dp),
            onClick = onClick
        )
    }
}