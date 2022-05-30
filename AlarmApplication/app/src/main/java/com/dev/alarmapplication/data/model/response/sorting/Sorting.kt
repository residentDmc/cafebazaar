package com.dev.alarmapplication.data.model.response.sorting


import com.google.gson.annotations.SerializedName

data class Sorting(
    @SerializedName("title")
    val title: String,
    @SerializedName("value")
    val value: String
)