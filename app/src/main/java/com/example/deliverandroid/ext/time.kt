package com.example.deliverandroid.ext

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

fun Long.toHourAndMinutes(): String {
    return SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(this))
}

fun Long.toMinuteAndSeconds(): String {
    return SimpleDateFormat("mm:ss", Locale.getDefault()).format(Date(this))
}



fun Calendar.isToday(time: Long?): Boolean {
    if (time == null) return false

    val target = Calendar.getInstance()
    target.timeInMillis = time
    return this[Calendar.YEAR] == target[Calendar.YEAR] && this[Calendar.MONTH] == target[Calendar.MONTH] && this[Calendar.DATE] == target[Calendar.DATE]
}


fun Long.offset(time: Long?): Int {
    return (this - (time ?: 0)).toInt() / 86400_000
}