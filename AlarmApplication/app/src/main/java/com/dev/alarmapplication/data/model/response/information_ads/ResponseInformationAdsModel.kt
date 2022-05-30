package com.dev.alarmapplication.data.model.response.information_ads


import com.google.gson.annotations.SerializedName

data class ResponseInformationAdsModel(
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("bumpStatus")
    val bumpStatus: String,
    @SerializedName("canBeBumped")
    val canBeBumped: Boolean,
    @SerializedName("carCertify")
    val carCertify: Any,
    @SerializedName("category")
    val category: Category,
    @SerializedName("certificate")
    val certificate: Any,
    @SerializedName("contactInfo")
    val contactInfo: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("expirationDateString")
    val expirationDateString: String,
    @SerializedName("expirationDateText")
    val expirationDateText: String,
    @SerializedName("hiddenPhoneNumber")
    val hiddenPhoneNumber: String,
    @SerializedName("identificationBadge")
    val identificationBadge: Any,
    @SerializedName("identificationCarBadge")
    val identificationCarBadge: Any,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("isChatEnabled")
    val isChatEnabled: Boolean,
    @SerializedName("isSpecial")
    val isSpecial: Int,
    @SerializedName("isSpecialInHome")
    val isSpecialInHome: Int,
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("leasing")
    val leasing: String,
    @SerializedName("listingID")
    val listingID: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("moderationStatus")
    val moderationStatus: ModerationStatus,
    @SerializedName("ownerID")
    val ownerID: Int,
    @SerializedName("phoneNumberIsVerified")
    val phoneNumberIsVerified: Boolean,
    @SerializedName("priceString")
    val priceString: String,
    @SerializedName("priceTag")
    val priceTag: Any,
    @SerializedName("shopLogo")
    val shopLogo: String,
    @SerializedName("shouldShowContact")
    val shouldShowContact: Boolean,
    @SerializedName("sortInfo")
    val sortInfo: String,
    @SerializedName("statistics")
    val statistics: Any,
    @SerializedName("thumbImageURL")
    val thumbImageURL: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("userType")
    val userType: Int,
    @SerializedName("videos")
    val videos: List<Any>
)