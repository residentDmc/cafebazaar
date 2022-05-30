package com.dev.alarmapplication.data.model.response.view_all_user


import com.google.gson.annotations.SerializedName

data class Settings(
    @SerializedName("locale")
    val locale: String
)