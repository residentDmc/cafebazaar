package com.dev.alarmapplication.data.model.response.mission


import com.google.gson.annotations.SerializedName

data class ResponseMissionModel(
    @SerializedName("response")
    val response: Response
)