package kz.example.android.endlessdate.di

import kz.example.android.endlessdate.core.Constants
import kz.example.android.endlessdate.datasource.remote.ExchangeService
import kz.example.android.endlessdate.datasource.remote.createOkHttpClient
import kz.example.android.endlessdate.datasource.remote.createService
import kz.example.android.endlessdate.repository.ExchangeRepository
import kz.example.android.endlessdate.repository.ExchangeRepositoryImpl
import kz.example.android.endlessdate.views.exchange.ExchangeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val exchangeModule = module {
    single { createOkHttpClient() }
    single { createService<ExchangeService>(get(),Constants.BASE_URL) }
    single { ExchangeRepositoryImpl(get()) as ExchangeRepository }
    viewModel {
        ExchangeViewModel(
            get()
        )
    }
}