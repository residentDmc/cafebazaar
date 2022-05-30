package com.dev.alarmapplication.utils.extention

import android.app.Activity
import android.util.DisplayMetrics

fun getWidthDisplayMetrics(activity: Activity):Int {
    val displayMetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

fun getHeightDisplayMetrics(activity: Activity):Int {
    val displayMetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}