package com.example.crypto.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val baseURL: String = "https://min-api.cryptocompare.com/data/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseURL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}