package com.example.spotifyapp.view.componts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyapp.R
import org.w3c.dom.Text


@Composable
fun iconBtnTheme(
    modifier: Modifier = Modifier,
    icon: Int,
    text: String = "Темная тема",
    onClick: () -> Unit = {}
){

    val white = Color.White.copy(0.1f)

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(70.dp).clip(CircleShape)
                .background(color = white),
        ) {
            Icon(
                painter = painterResource(icon),
                "",
                modifier = Modifier.fillMaxSize()
                    .padding(10.dp), tint = Color.White)
        }

        Text(
            text =  text,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 19.sp,
            modifier = Modifier.padding(top = 20.dp)

        )
    }
}