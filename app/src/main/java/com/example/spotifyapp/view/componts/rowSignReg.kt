package com.example.spotifyapp.view.componts

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyapp.R


@Composable
@Preview(showBackground = true)
fun rowSignReg(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {}
){

    Row (
        modifier = Modifier.fillMaxWidth().then(modifier),
    ){
        iconBtnBackRegInSign(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = colorResource(R.color.graytext).copy(0.1f))
                .size(32.dp)

        , onClick = onClickBack)

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(R.drawable.registerinsignspotify),
            contentDescription = null,
            modifier = Modifier
                .width(133.dp)
                .height(33.dp)
                .padding(end = 33.dp)
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
}