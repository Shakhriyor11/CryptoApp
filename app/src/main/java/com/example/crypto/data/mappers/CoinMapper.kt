package com.example.crypto.data.mappers

import com.example.crypto.data.database.CoinInfoDBModel
import com.example.crypto.data.network.model.CoinInfoDto
import com.example.crypto.data.network.model.CoinInfoJsonContainerDto
import com.example.crypto.data.network.model.CoinNamesListDto
import com.example.crypto.domain.model.CoinInfo
import com.google.gson.Gson
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class CoinMapper {

    fun mapDtoToDBModel(dto: CoinInfoDto) = CoinInfoDBModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highday = dto.highday,
        lowday = dto.lowday,
        lastmarket = dto.lastmarket,
        imageurl = imageBaseURL + dto.imageurl
    )

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDBModel) = CoinInfo(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = convertTimeStampToTime(dbModel.lastUpdate),
        highday = dbModel.highday,
        lowday = dbModel.lowday,
        lastmarket = dbModel.lastmarket,
        imageurl = dbModel.imageurl
    )

    private fun convertTimeStampToTime(timeStamp: Long?): String {
        if (timeStamp == null) return ""
        val stamp = Timestamp(timeStamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object {

        const val imageBaseURL: String = "https://cryptocompare.com"
    }
}