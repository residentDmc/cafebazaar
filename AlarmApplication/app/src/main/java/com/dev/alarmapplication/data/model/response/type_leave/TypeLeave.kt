package com.dev.alarmapplication.data.model.response.type_leave


import com.google.gson.annotations.SerializedName

data class TypeLeave(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)