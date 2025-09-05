package com.example.spotifyapp.view.componts

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import com.example.spotifyapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TextFieldInput(
    placeholderText: String = "Введите свой Email",
    modifier: Modifier = Modifier.fillMaxWidth(),
    @DrawableRes id: Int? = null,
    onText: (String) -> Unit

) {
    var text by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = { newString ->
            text = newString
            onText(text)
                        },
        shape = RoundedCornerShape(30.dp),
        modifier = modifier.height(80.dp),
        placeholder = {
            Text(
                text = placeholderText,
                modifier = Modifier.fillMaxHeight()
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        },
        textStyle = LocalTextStyle.current.copy(
            fontSize = 16.sp,
            lineHeight = 50.sp
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        ),

        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),


        trailingIcon = {
           if (id != null){
               IconButton(
                   onClick = {
                       passwordVisible = !passwordVisible
                   },
                   modifier  = Modifier
               ) {
                   Icon(
                       painter = painterResource(id),
                       contentDescription = "Показать/скрыть пароль",
                       tint = Color.Gray, // можно убрать, если PNG цветной
                       modifier = Modifier.scale(4f)
                           .padding(top = 10.dp)// стандартный размер иконки

                   )
               }
           }
        }
    )
}
