package kz.example.android.endlessdate.repository

import kz.example.android.endlessdate.data.ExchangeApiResponce

interface ExchangeRepository {

    suspend fun getDayExchange(year: Int, month: Int, day: Int): ExchangeApiResponce
}
