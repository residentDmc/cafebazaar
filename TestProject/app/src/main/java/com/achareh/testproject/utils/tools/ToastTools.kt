package com.achareh.testproject.utils.tools

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.achareh.testproject.R
import com.achareh.testproject.utils.application.AppTestProject


@Suppress("DEPRECATION")
class ToastTools {

    fun toast(message: String) {
        val layout: View = AppTestProject.activity.layoutInflater.inflate(
            R.layout.toast_layout,
            AppTestProject.activity.findViewById<View>(R.id.custom_toast_layout_id) as ViewGroup?)
        val text = layout.findViewById<View>(R.id.text) as TextView
        text.setTextColor(Color.WHITE)
        text.text = message
        val lytCard = layout.findViewById<View>(R.id.lyt_card) as CardView
        lytCard.setCardBackgroundColor(AppTestProject.activity.resources.getColor(R.color.colorBlack))

        val toast = Toast(AppTestProject.activity)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}