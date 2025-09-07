package com.example.spotifyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyapp.modal.dataobj.ChooseModeScreen
import com.example.spotifyapp.modal.dataobj.RegisterSignInObj
import com.example.spotifyapp.modal.dataobj.SigInScreenObj
import com.example.spotifyapp.modal.dataobj.SplashScreenObj
import com.example.spotifyapp.modal.dataobj.StartedScreenObj
import com.example.spotifyapp.view.screens.SignInScreen
import com.example.spotifyapp.view.screens.chooseModeScreen
import com.example.spotifyapp.view.screens.registerSignInScreen
import com.example.spotifyapp.view.screens.startedScreen
import com.example.spotifyapp.view.screens.splashScreen
import com.example.spotifyapp.viewModal.AuthUserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AuthUserViewModel by viewModels()// <-- добавляем ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Получаем текущего пользователя
        viewModel.getCurrentUser()

        lifecycleScope.launchWhenStarted {
            viewModel.currentUser.collect { user ->
                user?.let {
                    Log.d("AUTH_LOG", "Пользователь вошел:")
                    Log.d("AUTH_LOG", "UID: ${it.uuid}")
                    Log.d("AUTH_LOG", "Email: ${it.email}")
                    Log.d("AUTH_LOG", "Имя: ${it.name}")
                    Log.d("AUTH_LOG", "Email подтвержден: ${it.emailVerify}")
                } ?: run {
                    Log.d("AUTH_LOG", "Нет активного пользователя.")
                }
            }
        }

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = SplashScreenObj) {
                composable<SplashScreenObj> {
                    splashScreen {
                        navController.navigate(StartedScreenObj) {
                            popUpTo<SplashScreenObj> { inclusive = true }
                        }
                    }
                }

                composable<StartedScreenObj> {
                    startedScreen {
                        navController.navigate(route = ChooseModeScreen)
                    }
                }

                composable<ChooseModeScreen> {
                    chooseModeScreen {
                        navController.navigate(RegisterSignInObj)
                    }
                }

                composable<RegisterSignInObj> {
                    registerSignInScreen(
                        clickBAck = { navController.popBackStack() },
                        clickReg = {},
                        clickSign = { navController.navigate(SigInScreenObj) }
                    )
                }

                composable<SigInScreenObj> {
                    SignInScreen(
                        onClickBack = { navController.popBackStack() },
                        onClickGoogle = {},
                        onClickApple = {},
                        onClickRestartPass = {},
                        clickRegister = {},
                        onLoginSuccess = {
                            // TODO: Навигация после успешного входа
                        }
                    )
                }
            }
        }
    }
}
