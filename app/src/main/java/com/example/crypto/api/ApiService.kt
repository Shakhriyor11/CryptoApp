package com.example.crypto.api

import com.example.crypto.pojo.CoinInfoListOfData
import com.example.crypto.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(PARAMS_QUERY_API_KEY) api_key: String = API_KEY,
        @Query(PARAMS_QUERY_LIMIT) limit: Int = LIMIT,
        @Query(PARAMS_QUERY_TO_SYMBOL) tsym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(PARAMS_QUERY_API_KEY) api_key: String = API_KEY,
        @Query(PARAMS_QUERY_FROM_SYMBOLS) fsyms: String,
        @Query(PARAMS_QUERY_TO_SYMBOLS) tsyms: String = CURRENCY
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val PARAMS_QUERY_API_KEY = "api_key"
        private const val PARAMS_QUERY_LIMIT = "limit"
        private const val PARAMS_QUERY_TO_SYMBOL = "tsym"
        private const val PARAMS_QUERY_TO_SYMBOLS = "tsyms"
        private const val PARAMS_QUERY_FROM_SYMBOLS = "fsyms"

        private const val API_KEY: String = "6afdae3207dcb4c1b33fe8f9eafa995c7f05e284dd694fc63dfc7c4686a2dc5a"
        private const val LIMIT: Int = 10
        private const val CURRENCY: String = "USD"
    }
}