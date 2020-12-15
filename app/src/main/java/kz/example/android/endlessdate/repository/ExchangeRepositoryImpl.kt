package kz.example.android.endlessdate.repository

import kz.example.android.endlessdate.datasource.remote.ExchangeService

class ExchangeRepositoryImpl(private val exchangeService: ExchangeService): ExchangeRepository{

    override suspend fun getDayExchange(year: Int, month: Int, day: Int) = exchangeService.getDayExchange(year, month, day)

}