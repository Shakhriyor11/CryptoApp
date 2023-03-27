package com.example.crypto.domain.repository

import androidx.lifecycle.LiveData
import com.example.crypto.domain.model.CoinInfo

interface CoinRepository {
    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}