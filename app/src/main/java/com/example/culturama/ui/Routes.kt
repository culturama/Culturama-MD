package com.example.culturama.ui

sealed class Routes(val route: String) {
    object SignUp : Routes("SignUp")
    object Login : Routes("Login")
}