package com.dev.alarmapplication.utils.extention

import java.text.DecimalFormat

fun filterDoubleNumber(number:String):String{
    val precision = DecimalFormat("#.##")
    return precision.format(number)
}