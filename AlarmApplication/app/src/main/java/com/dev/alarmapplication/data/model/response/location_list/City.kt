package com.orinab.adsorinabapplication.data.model.response.location_list


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("allowedToFilterByDistrict")
    val allowedToFilterByDistrict: Boolean,
    @SerializedName("cityID")
    val cityID: Int,
    @SerializedName("districts")
    val districts: List<District>,
    @SerializedName("isCapital")
    val isCapital: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("ownCity")
    val ownCity: List<Any>,
    @SerializedName("slug")
    val slug: String
)