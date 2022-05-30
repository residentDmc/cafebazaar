package com.dev.alarmapplication.utils.extention

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import com.dev.alarmapplication.utils.application.AppOfficialOrinab

fun bitmapDescriptorFromVector(vectorResId: Int): Bitmap? {
    val vectorDrawable = ContextCompat.getDrawable(AppOfficialOrinab.context, vectorResId)
    vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
    val bitmap = Bitmap.createBitmap(
        vectorDrawable.intrinsicWidth,
        vectorDrawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    vectorDrawable.draw(canvas)
    return bitmap
}