package com.dev.alarmapplication.data.model.response.error_sheypoor


import com.google.gson.annotations.SerializedName

data class ResponseErrorSheypoorModel(
    @SerializedName("error")
    val error: Error
)