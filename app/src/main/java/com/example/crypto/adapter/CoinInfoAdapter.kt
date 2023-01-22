package com.example.crypto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.crypto.R
import com.example.crypto.pojo.CoinInfo
import com.example.crypto.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter: RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var onCoinClickLitener: OnCoinClickLitener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info,parent,false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                tvSymbols.text = fromSymbol + " / " + toSymbol
                tvPrice.text = price.toString()
                tvLastUpdate.text = getFormattedTime()
                Picasso.get().load(getFullImageUrl()).into(holder.ivLogoCoin)
                itemView.setOnClickListener {
                    onCoinClickLitener?.onClick(this)
                }
            }
        }
    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(itemView: View): ViewHolder(itemView){
        val ivLogoCoin = itemView.ivLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvPrice = itemView.tvPrice
        val tvLastUpdate = itemView.tvLastUpdate
    }

    interface OnCoinClickLitener {
        fun onClick(coinPriceInfo: CoinPriceInfo)
    }

}