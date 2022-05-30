package com.dev.alarmapplication.data.model.request.add_ads


import com.google.gson.annotations.SerializedName

class RequestAddAdsModel{
    @SerializedName("adId")
    var adId: Int=0
    @SerializedName("attributes")
    var attributes: ArrayList<Attribute> =ArrayList()
    @SerializedName("categoryID")
    var categoryID: Int=0
    @SerializedName("description")
    var description: String=""
    @SerializedName("images")
    var images: ArrayList<Image> =ArrayList()
    @SerializedName("locationID")
    var locationID: Int=0
    @SerializedName("locationType")
    var locationType: Int=0
    @SerializedName("telephone")
    var telephone: String=""
    @SerializedName("title")
    var title: String=""
    @SerializedName("userType")
    var userType: Int=0
}