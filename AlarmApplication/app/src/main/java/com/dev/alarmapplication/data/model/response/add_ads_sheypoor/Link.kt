package com.dev.alarmapplication.data.model.response.add_ads_sheypoor


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)