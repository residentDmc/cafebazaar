package com.dev.alarmapplication.utils.extention.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REQUEST_ID_MULTIPLE_PERMISSIONS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REQUEST_ID_STORAGE_PERMISSIONS


fun checkAndRequestLocationPermissions(activity: Activity): Boolean {
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    val findLocation: Int =
        ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
    if (findLocation != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
    return if (listPermissionsNeeded.isNotEmpty()) {
        ActivityCompat.requestPermissions(
            activity,
            listPermissionsNeeded.toTypedArray(),
            REQUEST_ID_MULTIPLE_PERMISSIONS
        )
        false
    }else
        true
}

fun checkAndRequestStoragePermissions(activity: Activity): Boolean {
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    val arrayStorage = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    arrayStorage.forEach {
        val result = ContextCompat.checkSelfPermission(activity, it)
        if (result != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(it)
    }
    return if (listPermissionsNeeded.isNotEmpty()) {
        ActivityCompat.requestPermissions(
            activity,
            listPermissionsNeeded.toTypedArray(),
            REQUEST_ID_STORAGE_PERMISSIONS
        )
        false
    }else
        true
}

fun checkAndRequestLocationBackgroundPermissions(activity: Activity): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        val findLocation: Int = ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
        if (findLocation != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                activity,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        return true
    }
    return false
}

fun checkLocationPermissions(activity: Activity): Boolean {
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    val findLocation: Int =
        ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
    if (findLocation != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
    return listPermissionsNeeded.isEmpty()
}


fun checkStoragePermissions(activity: Activity): Boolean {
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    val arrayStorage = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    arrayStorage.forEach {
        val result = ContextCompat.checkSelfPermission(activity, it)
        if (result != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(it)
    }
    return listPermissionsNeeded.isEmpty()
}


fun checkLocationBackgroundPermissions(activity: Activity): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        val findLocation: Int = ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
        if (findLocation != PackageManager.PERMISSION_GRANTED) listPermissionsNeeded.add(
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        )
        return listPermissionsNeeded.isEmpty()
    }
    return false
}