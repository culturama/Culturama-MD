package com.example.culturama.ui.navigation

sealed class Route (val route: String) {
    object SplashScreen: Route("splashScreen")
    object AppStartNavigation: Route("appStartNavigation")
    object OnBoardingScreen: Route("onBoardingScreen")
    object Login: Route("loginScreen")
    object SignUp: Route("registerScreen")
    object ResetPasswordScreen: Route("ResetPasswordScreen")
    object HomeScreen: Route("homeScreen")
    object FavoriteScreen: Route("favoriteScreen")
    object ProfileScreen: Route("profileScreen")
    object DetailScreen: Route("homeScreen/{cultureId}") {
        fun createRoute(cultureId: Long) = "homeScreen/$cultureId"
    }
    object CultureNavigation: Route("cultureNavigation")
    object CultureNavigatorScreen: Route("cultureNavigationScreen")
}
