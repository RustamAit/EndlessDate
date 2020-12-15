package kz.example.android.endlessdate.datasource.remote

import android.content.Context
import kz.example.android.endlessdate.core.utills.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun createOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Logger.api(message) })
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .connectTimeout(180L, TimeUnit.SECONDS)
        .readTimeout(180L, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()
}

inline fun <reified T> createService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}
