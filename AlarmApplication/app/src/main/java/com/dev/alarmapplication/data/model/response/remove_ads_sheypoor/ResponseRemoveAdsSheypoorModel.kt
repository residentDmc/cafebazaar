package com.dev.alarmapplication.data.model.response.remove_ads_sheypoor


import com.google.gson.annotations.SerializedName

data class ResponseRemoveAdsSheypoorModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("listingID")
    val listingID: String,
    @SerializedName("message")
    val message: String
)