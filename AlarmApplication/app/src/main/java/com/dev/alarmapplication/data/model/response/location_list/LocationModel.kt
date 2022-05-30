package com.orinab.adsorinabapplication.data.model.response.location_list


import com.google.gson.annotations.SerializedName
import com.orinab.adsorinabapplication.data.model.response.location_list.City

data class LocationModel(
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