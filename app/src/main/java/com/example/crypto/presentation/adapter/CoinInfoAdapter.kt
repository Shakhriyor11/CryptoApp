package com.example.crypto.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.crypto.R
import com.example.crypto.databinding.ItemCoinInfoBinding
import com.example.crypto.domain.model.CoinInfo
import com.example.crypto.presentation.adapter.diff_utils.CoinInfoDiffCallBack
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) : ListAdapter<CoinInfo, CoinInfoViewHolder>(
    CoinInfoDiffCallBack
) {

    var onCoinClickLitener: OnCoinClickLitener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                val symbolTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                tvSymbols.text = String.format(symbolTemplate, fromSymbol, toSymbol)
                tvPrice.text = price.toString()
                tvLastUpdate.text = lastUpdate
                Picasso.get().load(imageurl).into(ivLogoCoin)
                root.setOnClickListener {
                    onCoinClickLitener?.onClick(this)
                }
            }
        }
    }

    interface OnCoinClickLitener {
        fun onClick(coinPriceInfo: CoinInfo)
    }

}