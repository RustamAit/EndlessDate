package kz.example.android.endlessdate.views.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kz.example.android.endlessdate.core.utills.apiResource.ApiResource
import kz.example.android.endlessdate.core.utills.getDayByCalendar
import kz.example.android.endlessdate.core.utills.getMonthByCalendar
import kz.example.android.endlessdate.core.utills.getYearByCalendar
import kz.example.android.endlessdate.repository.ExchangeRepository
import java.lang.Exception
import java.util.*

class ExchangeViewModel(private val exchangeRepository: ExchangeRepository): ViewModel() {

    fun getDayExchange(date: Date) = liveData(Dispatchers.IO){
        emit(ApiResource.loading())
        try {
            emit(ApiResource.success(exchangeRepository.getDayExchange(date.getYearByCalendar(),date.getMonthByCalendar(),date.getDayByCalendar())))
        } catch (e: Exception){
            emit(ApiResource.error(null, e.message?:"Error"))
        }
    }



}