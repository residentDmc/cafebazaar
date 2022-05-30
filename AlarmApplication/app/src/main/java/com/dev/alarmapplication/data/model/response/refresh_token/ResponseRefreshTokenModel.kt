package com.dev.alarmapplication.data.model.response.refresh_token


import com.google.gson.annotations.SerializedName

data class ResponseRefreshTokenModel(
    @SerializedName("data")
    val refreshTokenModel: RefreshTokenModel,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)