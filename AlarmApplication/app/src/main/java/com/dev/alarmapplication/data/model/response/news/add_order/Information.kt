package com.dev.alarmapplication.data.model.response.news.add_order


import com.google.gson.annotations.SerializedName

data class Information(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String
)