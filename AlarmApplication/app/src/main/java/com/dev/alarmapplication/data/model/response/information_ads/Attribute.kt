package com.dev.alarmapplication.data.model.response.information_ads


import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("attributeGroupId")
    val attributeGroupId: Int,
    @SerializedName("attributeID")
    val attributeID: Any,
    @SerializedName("attributeLocalyticsKey")
    val attributeLocalyticsKey: String,
    @SerializedName("attributeStyleId")
    val attributeStyleId: Int,
    @SerializedName("attributeTitle")
    val attributeTitle: String,
    @SerializedName("attributeValue")
    val attributeValue: Any
)