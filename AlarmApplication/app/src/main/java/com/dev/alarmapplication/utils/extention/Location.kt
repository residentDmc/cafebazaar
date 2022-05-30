package com.dev.alarmapplication.utils.extention

import android.annotation.SuppressLint
import com.google.android.material.textfield.TextInputLayout
import com.dev.alarmapplication.data.model.response.information_ads.Location

@SuppressLint("SetTextI18n")
fun initSetLocationValue(textInputLayout: TextInputLayout, location: Location){
    location.city.let { city->
        when (city) {
            "" -> textInputLayout.editText!!.setText(location.region)
            else -> location.neighbourhood.let { neighbourhood->
                when (neighbourhood) {
                    "" -> textInputLayout.editText!!.setText("${location.region}-${location.city}")
                    else -> textInputLayout.editText!!.setText("${location.region}-${location.city}-${location.neighbourhood}")
                }
            }
        }
    }
}