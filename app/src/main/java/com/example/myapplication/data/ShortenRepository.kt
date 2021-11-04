package com.example.myapplication.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ShortenRepository {

    fun makeRequest(): ShortenAPI {
        val baseUrl = "https://api.shrtco.de/v2/"

        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ShortenAPI::class.java)
    }

}