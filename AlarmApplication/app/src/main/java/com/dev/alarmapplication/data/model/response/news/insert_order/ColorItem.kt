package com.dev.alarmapplication.data.model.response.news.insert_order


import com.google.gson.annotations.SerializedName

data class ColorItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("value")
    val value: Int
)