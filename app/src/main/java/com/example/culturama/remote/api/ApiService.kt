package com.example.culturama.remote.api

import com.example.culturama.remote.api.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/register")
    suspend fun registerUser(@Body requestBody: Map<String, String>): LoginResponse

    @POST("/login")
    suspend fun loginUser(@Body requestBody: Map<String, String>): LoginResponse
}
