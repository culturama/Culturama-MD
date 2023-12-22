package com.example.culturama.remote.api.response

data class LoginResponse(
    val error: Boolean,
    val loginResult: LoginResult? = null, // Adjust based on the actual response structure
    val message: String
)

data class LoginResult(
    val token: String
)
