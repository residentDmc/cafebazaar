package com.dev.alarmapplication.data.model.response.city_shop


import com.google.gson.annotations.SerializedName

data class Shop(
    @SerializedName("check")
    val check: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)