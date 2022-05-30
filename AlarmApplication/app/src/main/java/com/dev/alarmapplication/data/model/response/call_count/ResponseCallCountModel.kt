package com.dev.alarmapplication.data.model.response.call_count


import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.data.model.response.call_count.Response

data class ResponseCallCountModel(
    @SerializedName("response")
    val response: Response
)