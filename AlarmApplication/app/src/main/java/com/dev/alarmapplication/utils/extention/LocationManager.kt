package com.dev.alarmapplication.utils.extention

import android.content.Context
import android.location.LocationManager


fun checkGps(context: Context): Boolean {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return when {
        !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) -> return false
        else -> true

    }
}