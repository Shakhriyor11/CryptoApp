package com.example.crypto.presentation.adapter.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.example.crypto.domain.model.CoinInfo

object CoinInfoDiffCallBack: DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}