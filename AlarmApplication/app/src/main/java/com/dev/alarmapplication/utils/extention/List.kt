package com.dev.alarmapplication.utils.extention

import com.google.gson.Gson
import java.util.*

fun initFetchList(gson: Gson, value: String): List<String> =
    gson.fromJson(value, Array<String>::class.java).asList()