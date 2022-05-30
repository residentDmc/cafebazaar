package com.dev.alarmapplication.data.model.response.register


import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.data.model.response.register.Response

data class ResponseRegisterModel(
    @SerializedName("response")
    val response: Response
)