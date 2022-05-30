package com.dev.alarmapplication.data.model.response.mission


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)