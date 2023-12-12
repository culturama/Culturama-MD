package com.example.culturama.ui.navigation

sealed class Screen (val route: String) {
    object Splash: Screen("splash")
    object Home: Screen("home")
    object Favorite: Screen("favorite")
    object Profile: Screen("profile")
    object Detail: Screen("home/{cultureId}") {
        fun createRoute(cultureId: Long) = "home/$cultureId"
    }
}
