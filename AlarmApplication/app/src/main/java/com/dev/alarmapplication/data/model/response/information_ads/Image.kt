package com.dev.alarmapplication.data.model.response.information_ads


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("fullSizeURL")
    val fullSizeURL: String,
    @SerializedName("serverKey")
    val serverKey: String,
    @SerializedName("thumbnailURL")
    val thumbnailURL: String
)