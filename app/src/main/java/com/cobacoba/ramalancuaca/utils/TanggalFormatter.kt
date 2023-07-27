package com.cobacoba.ramalancuaca.utils

import java.text.SimpleDateFormat
import java.util.*

fun tanggalFormater(time:Int):String {
    val format = SimpleDateFormat("EEE, dd MMM YYYY", Locale.ENGLISH)
    val date = Date(time.toLong()*1000)
    return format.format(date)
}