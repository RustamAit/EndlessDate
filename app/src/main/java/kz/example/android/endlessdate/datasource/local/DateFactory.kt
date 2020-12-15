package kz.example.android.endlessdate.datasource.local

import kz.example.android.endlessdate.core.utills.minusDays
import java.util.*

object DateFactory {

    fun getDates(olderThan: Date): MutableList<Date> {
        val dateList = mutableListOf<Date>()
        for( i in 1 until 30){
            dateList.add(olderThan.minusDays(i))
        }
        return dateList
    }

}

