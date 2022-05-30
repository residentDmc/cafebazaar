package com.dev.alarmapplication.utils.extention

fun codeSplitterString(messageText: String): String {
    val sb = StringBuilder()
    for (i in messageText.indices) if (messageText[i] in '0'..'9') {
        sb.append(messageText[i])
    }
    return sb.toString()
}

fun codeSplitterLong(messageText: String): Long {
    val sb = StringBuilder()
    for (i in messageText.indices) if (messageText[i] in '0'..'9') {
        sb.append(messageText[i])
    }
    return sb.toString().toLong()
}