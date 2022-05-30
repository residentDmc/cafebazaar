package com.dev.alarmapplication.utils.extention

import android.content.Context
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.content.ContextCompat
import com.dev.alarmapplication.R

fun colorPhoneShaypoor(context: Context, textView: TextView, imageFilterView: ImageFilterView, status:Int): Unit = when (status) {
    1 -> {
        textView.setTextColor(context.resources.getColor(R.color.greenColor))
        imageFilterView.setColorFilter(ContextCompat.getColor(context, R.color.greenColor), android.graphics.PorterDuff.Mode.SRC_IN)
    }
    else -> {
        textView.setTextColor(context.resources.getColor(R.color.primary_text))
        imageFilterView.setColorFilter(ContextCompat.getColor(context, R.color.primary_text), android.graphics.PorterDuff.Mode.SRC_IN)
    }
}