package com.dev.alarmapplication.data.model.response.call_count


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("count_tell")
    val countTell: Int,
    @SerializedName("status")
    val status: Int
)