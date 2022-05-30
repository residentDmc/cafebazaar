package com.dev.alarmapplication.data.model.response.my_ads_shaypoor


import com.google.gson.annotations.SerializedName

data class AdsShaypoor(
    @SerializedName("bumpStatus")
    val bumpStatus: String,
    @SerializedName("canBeBumped")
    val canBeBumped: Boolean,
    @SerializedName("carCertify")
    val carCertify: Any,
    @SerializedName("certificate")
    val certificate: Any,
    @SerializedName("contactInfo")
    val contactInfo: String,
    @SerializedName("expirationDateString")
    val expirationDateString: String,
    @SerializedName("expirationDateText")
    val expirationDateText: String,
    @SerializedName("imagesCount")
    val imagesCount: Int,
    @SerializedName("isBumped")
    val isBumped: Boolean,
    @SerializedName("isSpecial")
    val isSpecial: Int,
    @SerializedName("isSpecialInHome")
    val isSpecialInHome: Int,
    @SerializedName("listingID")
    val listingID: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("moderationStatus")
    val moderationStatus: ModerationStatus,
    @SerializedName("priceString")
    val priceString: String,
    @SerializedName("priceTag")
    val priceTag: Any,
    @SerializedName("shopLogo")
    val shopLogo: String,
    @SerializedName("sortInfo")
    val sortInfo: String,
    @SerializedName("statistics")
    val statistics: Statistics,
    @SerializedName("thumbImageURL")
    val thumbImageURL: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)