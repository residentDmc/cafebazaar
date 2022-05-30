package com.dev.alarmapplication.data.model.response.location_shaypoor


import com.google.gson.annotations.SerializedName

data class LocationShaypoorModel(
    @SerializedName("allowedToFilterByCity")
    val allowedToFilterByCity: Boolean,
    @SerializedName("cities")
    val cities: List<City>,
    @SerializedName("isTop")
    val isTop: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("provinceID")
    val provinceID: Int,
    @SerializedName("slug")
    val slug: String
)