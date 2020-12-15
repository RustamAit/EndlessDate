package kz.example.android.endlessdate.views.dates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.example.android.endlessdate.core.utills.plusDays
import kz.example.android.endlessdate.datasource.local.DateFactory
import java.util.*
import kotlin.collections.ArrayList

class DatesViewModel(): ViewModel() {

    val datesLiveData: MutableLiveData<ArrayList<Date>> = MutableLiveData()

    init {
        fetchDateList()
    }

    fun fetchDateList(olderThan: Date = Calendar.getInstance().time.plusDays(1)){
        val dates = datesLiveData.value ?: ArrayList()
        dates.addAll(DateFactory.getDates(olderThan))
        datesLiveData.value = dates
    }

}