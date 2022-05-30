package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class HomeData(
    @SerializedName("title")
    val title: String,
    @SerializedName("value")
    val value: List<Value>
)