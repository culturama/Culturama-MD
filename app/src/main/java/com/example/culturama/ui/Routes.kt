package com.example.culturama.ui

sealed class Routes(val route: String) {
    object Login : Routes("Login")
}