package com.dev.alarmapplication.data.model.response.arrivals_and_departures


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    val message: String
)