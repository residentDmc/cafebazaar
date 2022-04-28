package com.achareh.testproject.data.model.response.address_list


import com.google.gson.annotations.SerializedName

data class AddressItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("address_id")
    val addressId: String,
    @SerializedName("coordinate_mobile")
    val coordinateMobile: String,
    @SerializedName("coordinate_phone_number")
    val coordinatePhoneNumber: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("region")
    val region: Region
)