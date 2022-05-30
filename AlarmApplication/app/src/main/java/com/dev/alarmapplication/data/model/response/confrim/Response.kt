package com.dev.alarmapplication.data.model.response.confrim


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)