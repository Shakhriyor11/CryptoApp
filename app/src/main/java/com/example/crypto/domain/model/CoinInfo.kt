package com.example.crypto.domain.model

data class CoinInfo(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String,
    val highday: String?,
    val lowday: String?,
    val lastmarket: String?,
    val imageurl: String
)