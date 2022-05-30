package com.dev.alarmapplication.data.model.response.error_sheypoor


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("errorCode")
    val errorCode: Int,
    @SerializedName("errorMessage")
    val errorMessage: String
)