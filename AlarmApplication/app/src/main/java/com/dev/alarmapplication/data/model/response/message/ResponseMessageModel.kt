package com.dev.alarmapplication.data.model.response.message


import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.data.model.response.arrivals_and_departures.Response

data class ResponseMessageModel(
    @SerializedName("response")
    val response: Response
)