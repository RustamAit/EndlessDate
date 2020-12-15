package kz.example.android.endlessdate.core.utills

import java.text.SimpleDateFormat
import java.util.*


fun Date.minusDays(numOfDays: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.DATE, -numOfDays)
    return cal.time
}

fun Date.plusDays(numOfDays: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.DATE, numOfDays)
    return cal.time
}

fun Date.formatDate(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.UK)
    return dateFormat.format(this)
}

fun Date.getDayByCalendar(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.DAY_OF_MONTH)
}

fun Date.getMonthByCalendar(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.MONTH) + 1
}

fun Date.getYearByCalendar(): Int{
    val cal = Calendar.getInstance()
    cal.time = this
    return cal.get(Calendar.YEAR)
}

