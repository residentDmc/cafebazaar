package com.orinab.adsorinabapplication.data.model.response.location_list


import com.google.gson.annotations.SerializedName
import com.orinab.adsorinabapplication.data.model.response.location_list.LocationModel

data class ResponseLocationModel(
    @SerializedName("data")
    val locationSheypoorModel: List<LocationModel>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("version")
    val version: Int
)