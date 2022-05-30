package com.dev.alarmapplication.data.model.request.add_ads


import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("attributeID")
    val attributeID: Int,
    @SerializedName("attributeValue")
    val attributeValue: String
)