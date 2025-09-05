package com.example.spotifyapp.view.componts

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyapp.R


@Composable
@Preview(showBackground = true)
fun iconBtnBackRegInSign(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){

    IconButton(
        onClick = onClick,
        modifier = modifier
        ){
        Icon(
            painter = painterResource(R.drawable.lefticon),
            "",
            modifier = Modifier.size(20.dp)

        )
    }
}