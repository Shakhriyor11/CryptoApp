package com.example.crypto.domain.interactor

import com.example.crypto.domain.repository.CoinRepository

class GetCoinInfoUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}