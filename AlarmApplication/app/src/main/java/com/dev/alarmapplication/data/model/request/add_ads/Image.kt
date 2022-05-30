package com.dev.alarmapplication.data.model.request.add_ads


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("imageKey")
    val imageKey: String,
    @SerializedName("isPrimary")
    val isPrimary: Boolean
)