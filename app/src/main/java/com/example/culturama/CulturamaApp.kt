package com.example.culturama

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.culturama.ui.navigation.Screen
import com.example.culturama.ui.screen.boarding.OnBoardingScreen
import com.example.culturama.ui.screen.splash.SplashScreen

@Composable
fun CulturamaApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController)
        }

        composable(route = Screen.Home.route) {

        }
    }
}
