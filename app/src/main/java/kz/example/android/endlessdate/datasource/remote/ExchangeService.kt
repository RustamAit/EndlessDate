package kz.example.android.endlessdate.datasource.remote

import kz.example.android.endlessdate.data.ExchangeApiResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ExchangeService {

    @GET("archive/{year}/{month}/{day}/daily_json.js")
    suspend fun getDayExchange(@Path("year") year: Int, @Path("month") month: Int, @Path("day") day: Int): ExchangeApiResponce

}