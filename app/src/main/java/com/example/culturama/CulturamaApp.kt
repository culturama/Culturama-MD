package com.example.culturama

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//@Composable
//fun CulturamaApp (
//    modifier: Modifier = Modifier,
//    navController: NavHostController = rememberNavController()
//) {
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Splash.route
//    ) {
//        composable(route = Screen.Splash.route) {
//            SplashScreen(navController)
//        }
//
//        composable(route = Screen.OnBoarding.route) {
//            OnBoardingScreen(navController)
//        }
//
//        composable(route = Screen.Home.route) {
//
//        }
//    }
//}

@HiltAndroidApp
class CulturamaApp: Application() {

}