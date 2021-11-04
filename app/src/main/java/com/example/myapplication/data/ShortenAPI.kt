package com.example.myapplication.data

import com.example.myapplication.model.Shorten
import retrofit2.http.POST
import retrofit2.http.Query

interface ShortenAPI {

    @POST("shorten")
    suspend fun encurtar(
        @Query("url")url: String
    ): Shorten

}