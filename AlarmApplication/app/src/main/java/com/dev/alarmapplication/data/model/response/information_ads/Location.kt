package com.dev.alarmapplication.data.model.response.information_ads


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String?,
    @SerializedName("locationID")
    val locationID: Int,
    @SerializedName("locationType")
    val locationType: Int,
    @SerializedName("neighbourhood")
    val neighbourhood: String?,
    @SerializedName("region")
    val region: String
)