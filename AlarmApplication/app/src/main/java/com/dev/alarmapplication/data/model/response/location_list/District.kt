package com.orinab.adsorinabapplication.data.model.response.location_list


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