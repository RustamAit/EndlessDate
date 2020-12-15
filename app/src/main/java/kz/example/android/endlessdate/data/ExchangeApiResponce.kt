package kz.example.android.endlessdate.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class ExchangeApiResponce(
    @SerializedName("Date") val date: Date,
    @SerializedName("Valute") val valute: ExchangeRate
)

data class ExchangeRate(
    val GBP: Currency,
    val USD: Currency,
    val KZT: Currency,
    val EUR: Currency
)