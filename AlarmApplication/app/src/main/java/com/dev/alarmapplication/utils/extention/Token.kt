package com.dev.alarmapplication.utils.extention

import java.util.*

fun getToken(chars: Int): String {
    val charSet = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$"
    var token = ""
    for (a in 1..chars) token += charSet[Random().nextInt(charSet.length)]
    return token
}