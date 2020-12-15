package kz.example.android.endlessdate.di

import kz.example.android.endlessdate.views.dates.DatesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dateModule = module {
    viewModel { DatesViewModel() }
}