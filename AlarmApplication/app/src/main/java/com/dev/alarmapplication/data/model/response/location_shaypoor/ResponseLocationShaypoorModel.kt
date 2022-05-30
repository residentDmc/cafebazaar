package com.dev.alarmapplication.data.model.response.location_shaypoor


import com.google.gson.annotations.SerializedName

data class ResponseLocationShaypoorModel(
    @SerializedName("data")
    val locationSheypoorModel: List<LocationShaypoorModel>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("version")
    val version: Int
)