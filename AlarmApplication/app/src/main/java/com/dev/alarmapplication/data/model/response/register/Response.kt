package com.dev.alarmapplication.data.model.response.register


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)