package com.example.spotifyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyapp.modal.ChooseModeScreen
import com.example.spotifyapp.modal.RegisterSignInObj
import com.example.spotifyapp.modal.SigInScreenObj
import com.example.spotifyapp.modal.SplashScreenObj
import com.example.spotifyapp.modal.StartedScreenObj
import com.example.spotifyapp.view.screens.chooseModeScreen
import com.example.spotifyapp.view.screens.registerSignInScreen
import com.example.spotifyapp.view.screens.signInScreen
import com.example.spotifyapp.view.screens.startedScreen
import com.example.spotifyapp.view.screens.splashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navcontroller = rememberNavController()


            NavHost(navController = navcontroller, startDestination = SplashScreenObj)
            {
                composable<SplashScreenObj>{
                    splashScreen {
                        navcontroller.navigate(StartedScreenObj){
                            popUpTo<SplashScreenObj> { inclusive = true }
                        }
                    }
                }

                composable<StartedScreenObj>{
                    startedScreen {
                        navcontroller.navigate(route = ChooseModeScreen)
                    }
                }

                composable<ChooseModeScreen> {
                    chooseModeScreen {
                        navcontroller.navigate(RegisterSignInObj)
                    }
                }

                composable<RegisterSignInObj> {
                    registerSignInScreen(
                        clickBAck = {
                            navcontroller.popBackStack()
                        },
                        clickReg = {},
                        clickSign = {
                            navcontroller.navigate(SigInScreenObj)
                        }
                    )
                }



            }
        }
    }
}
