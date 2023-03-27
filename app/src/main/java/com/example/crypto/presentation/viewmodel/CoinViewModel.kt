package com.example.crypto.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.crypto.data.network.model.CoinInfoDto
import com.example.crypto.data.repository.CoinRepositoryImpl
import com.example.crypto.domain.interactor.GetCoinInfoListUseCase
import com.example.crypto.domain.interactor.GetCoinInfoUseCase
import com.example.crypto.domain.interactor.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) =  getCoinInfoUseCase(fSym)


    init {
            loadDataUseCase()
    }
}