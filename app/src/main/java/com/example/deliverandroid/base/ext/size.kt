package com.example.deliverandroid.base.ext

import android.util.TypedValue
import android.view.View
import kotlin.math.roundToInt

fun Long.toMB(format: String): String {
    val mb = (this.toFloat() / 1024 / 1024).roundToInt()
    return String.format(format, mb)
}

fun View.sp(value: Int) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value.toFloat(), resources.displayMetrics)



