package com.dev.alarmapplication.data.model.response.my_ads_shaypoor


import com.google.gson.annotations.SerializedName

data class ResponseMyAdsShaypoorModel(
    @SerializedName("listings")
    val listings: List<AdsShaypoor>,
    @SerializedName("totalCount")
    val totalCount: String
)