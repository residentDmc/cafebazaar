package com.dev.alarmapplication.data.model.local.date

import ir.hamsaa.persiandatepicker.api.PersianPickerDate
import saman.zamani.persiandate.PersianDate

data class DateModel(
    val date: Int,
    val day: Int,
    val mont: Int,
    val result_date: String,
    val result_time_date: PersianPickerDate
)