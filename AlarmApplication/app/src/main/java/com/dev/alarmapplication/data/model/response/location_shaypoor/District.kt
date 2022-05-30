package com.dev.alarmapplication.data.model.response.location_shaypoor


import com.google.gson.annotations.SerializedName

data class District(
    @SerializedName("districtID")
    val districtID: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("showInFilters")
    val showInFilters: String,
    @SerializedName("showInListingForm")
    val showInListingForm: String
)