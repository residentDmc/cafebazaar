package com.dev.alarmapplication.data.model.response.mission_type


import com.google.gson.annotations.SerializedName

data class TypeMission(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)