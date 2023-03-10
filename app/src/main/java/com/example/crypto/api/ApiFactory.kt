package com.example.crypto.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val baseURL: String = "https://min-api.cryptocompare.com/data/"
    const val imageBaseURL: String = "https://cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseURL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}