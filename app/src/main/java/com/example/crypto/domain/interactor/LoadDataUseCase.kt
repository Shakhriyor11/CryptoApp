package com.example.crypto.domain.interactor

import com.example.crypto.domain.repository.CoinRepository

class LoadDataUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.loadData()
}