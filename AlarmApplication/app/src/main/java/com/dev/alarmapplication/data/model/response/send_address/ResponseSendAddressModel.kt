package com.dev.alarmapplication.data.model.response.send_address


import com.google.gson.annotations.SerializedName

data class ResponseSendAddressModel(
    @SerializedName("state")
    val state: String,
    @SerializedName("text")
    val text: String
)