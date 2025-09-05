package com.example.spotifyapp.view.screens

import android.bluetooth.BluetoothGatt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.spotifyapp.R
import com.example.spotifyapp.ui.theme.GrayIConBtn
import com.example.spotifyapp.ui.theme.GrayTextRegInSign
import com.example.spotifyapp.view.componts.iconBtnBackRegInSign
import com.example.spotifyapp.view.componts.startedButton


@Composable
fun registerSignInScreen(
    clickBAck: () -> Unit,
    clickReg : () -> Unit,
    clickSign: () -> Unit
){

    val grayText = GrayTextRegInSign.copy(0.7f)

    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
    ) {

        iconBtnBackRegInSign(
            modifier = Modifier
                .padding(top = 40.dp, start = 34.dp)
                .clip(CircleShape)
                .size(32.dp)
                .background(color = GrayIConBtn.copy(0.06f)),
            onClick = clickBAck
        )

        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 111.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.registerinsignspotify),
                contentDescription = null,
                modifier = Modifier.width(235.dp).height(71.dp)
                    .clip(RoundedCornerShape(32.dp))
            )
        }

        Text(
            text = "Наслаждайтесь прослушиванием музыки",
            fontSize = 26.sp,
            fontWeight = Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 55.dp).padding(horizontal = 10.dp),
            color = Color(0xFF383838)
        )

        Text(
            text = "\n" +
                    "Spotify - проприетарный " +
                    "шведский поставщик услуг потоковой " +
                    "передачи аудио и мультимедиа",
            fontSize = 17.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Center,
            color = grayText,
            modifier = Modifier.padding(horizontal = 34.dp)
        )

        ConstraintLayout(
            modifier = Modifier.fillMaxSize().padding(top = 40.dp)
        ) {
            val (image, union, btnReg, btnSignIn) = createRefs()

            Image(
                painter = painterResource(R.drawable.gerl3),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
                    .constrainAs(image){
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentScale = ContentScale.Crop,
            )

            Image(
                painter = painterResource(R.drawable.union),
                contentDescription = null,
                contentScale = ContentScale.Crop ,
                modifier = Modifier.height(400.dp).width(250.dp)
                    .constrainAs(union){
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                alpha = 0.8f
            )

            startedButton(
                text = "Регистрация",
                verticalPadding = 23.dp,
                horizontalPading = 0.dp,
                fontSize = 19.sp,
                modifier = Modifier.constrainAs(btnReg){
                    absoluteLeft.linkTo(parent.absoluteLeft,
                        margin = 30.dp)

                    top.linkTo(parent.top)
                },

                onClick = clickReg

            )

            TextButton(
                onClick = clickSign,
                modifier = Modifier.constrainAs(btnSignIn){
                    start.linkTo(btnReg.end, margin = 15.dp)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    "Войти",
                    fontSize = 19.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(23.dp)
                        .padding(horizontal = 30.dp)

                )
            }

        }
    }

}