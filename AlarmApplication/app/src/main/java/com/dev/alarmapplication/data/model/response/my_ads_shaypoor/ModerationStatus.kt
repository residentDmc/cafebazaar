package com.dev.alarmapplication.data.model.response.my_ads_shaypoor


import com.google.gson.annotations.SerializedName

data class ModerationStatus(
    @SerializedName("color")
    val color: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String
)