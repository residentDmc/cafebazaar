package com.dev.alarmapplication.data.model.response.refresh_token


import com.google.gson.annotations.SerializedName

data class Access(
    @SerializedName("token")
    val token: String,
    @SerializedName("ttl")
    val ttl: Int
)