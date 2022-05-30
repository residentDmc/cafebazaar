package com.dev.alarmapplication.data.model.response.refresh_token


import com.google.gson.annotations.SerializedName

data class RefreshTokenModel(
    @SerializedName("access")
    val access: Access,
    @SerializedName("userId")
    val userId: String
)