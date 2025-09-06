package com.example.spotifyapp.view.componts

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyapp.R


@Preview(showBackground = true)
@Composable
fun startedButton(
    onClick: () -> Unit = {},
    text: String = "Далее",
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 20.dp,
    horizontalPading: Dp = 100.dp,
    fontSize: TextUnit = 22.sp

){
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.greenBtn)
        ),
        shape = RoundedCornerShape(30.dp)
    ){
        Text(
            text,
            fontSize = fontSize,
            fontWeight = Bold,
            modifier = Modifier.padding(vertical = verticalPadding,
                horizontal = horizontalPading))
    }
}