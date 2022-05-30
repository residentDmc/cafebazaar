package com.dev.alarmapplication.data.model.response.add_ads_sheypoor


import com.google.gson.annotations.SerializedName

data class ResponseAddAdsModel(
    @SerializedName("action")
    val action: Int,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("listingID")
    val listingID: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("paidFeatures")
    val paidFeatures: List<Any>,
    @SerializedName("price")
    val price: String,
    @SerializedName("securePurchaseFlag")
    val securePurchaseFlag: Int,
    @SerializedName("title")
    val title: String
)