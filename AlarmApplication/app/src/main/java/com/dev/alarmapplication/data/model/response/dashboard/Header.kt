package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)