package com.example.spotifyapp.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.spotifyapp.R
import com.example.spotifyapp.view.componts.TextFieldInput
import com.example.spotifyapp.view.componts.rowSignReg
import com.example.spotifyapp.view.componts.startedButton
import com.example.spotifyapp.viewModal.AuthUserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: AuthUserViewModel = hiltViewModel(),
    onClickGoogle: () -> Unit = {},
    onClickApple: () -> Unit = {},
    onClickBack: () -> Unit = {},
    onClickRestartPass: () -> Unit = {},
    clickRegister: () -> Unit,
    onLoginSuccess: () -> Unit // Навигация после успешного входа
) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isLoading by viewModel.isLoading.collectAsState()
    val authError by viewModel.authError.collectAsState()
    val authSuccess by viewModel.authSuccess.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        rowSignReg(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 31.dp),
            onClickBack = onClickBack
        )

        Text(
            text = "Войти",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 80.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF383838)
        )

        TextFieldInput(
            placeholderText = "Введите свой UserName",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp)
                .padding(top = 30.dp),
            onText = { usernameInput ->
                userName = usernameInput
            }
        )

        TextFieldInput(
            placeholderText = "Пароль",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp)
                .padding(top = 25.dp),
            id = R.drawable.hide,
            onText = { passwordInput ->
                password = passwordInput
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 45.dp)
                .padding(top = 20.dp),
        ) {
            Text(
                text = "Сбросить пароль",
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable {
                    onClickRestartPass()
                }
            )
        }

        startedButton(
            text = if (isLoading) "Загрузка..." else "Войти",
            onClick = {
                if (!isLoading) {
                    if (userName.trim().isEmpty() || password.trim().isEmpty()){
                        return@startedButton
                    }
                    else{
                        viewModel.login(userName.trim(), password.trim())
                    }
                }
            },
            verticalPadding = 25.dp,
            horizontalPading = 90.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .padding(horizontal = 33.dp),
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 31.dp)
                .padding(horizontal = 33.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier = Modifier.weight(1f).height(1.dp))
            Text(
                text = "Или",
                modifier = Modifier.padding(horizontal = 20.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(modifier = Modifier.weight(1f).height(1.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onClickGoogle, modifier = Modifier.size(32.dp)) {
                Icon(
                    painterResource(R.drawable.google2),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.size(48.dp))

            IconButton(onClick = onClickApple) {
                Icon(
                    painterResource(R.drawable.apple),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "Нет аккаунта?", fontSize = 14.sp)
            Text(
                text = "Зарегистрироваться",
                fontSize = 14.sp,
                color = Color.Blue,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .clickable(onClick = clickRegister)
            )
        }

        // === Показываем ошибку ===
        authError?.let {
            Text(
                text = it,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }

    // Навигация при успешном входе
    LaunchedEffect(authSuccess) {
        if (authSuccess == true) {
            viewModel.clearMessages()
            onLoginSuccess()
        }
    }
}
