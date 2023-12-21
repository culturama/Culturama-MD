package com.example.culturama.data.remote

import com.example.culturama.data.remote.dto.CultureResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CultureApi {

    @GET("everything")
    suspend fun getCulture(
        @Query("page") page: Int,
        @Query("accessToken") accessToken: String,
    ) : CultureResponse
}