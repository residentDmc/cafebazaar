package com.dev.alarmapplication.data.model.response.error


import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.data.model.response.arrivals_and_departures.Response

data class ResponseErrorModel(
    @SerializedName("response")
    val response: Response
)