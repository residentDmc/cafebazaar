package com.achareh.testproject.data.model.request.save_address


import com.google.gson.annotations.SerializedName

class RequestSaveAddressModel {
    @SerializedName("address")
    var address: String = ""

    @SerializedName("coordinate_mobile")
    var coordinateMobile: String = ""

    @SerializedName("coordinate_phone_number")
    var coordinatePhoneNumber: String = ""

    @SerializedName("first_name")
    var firstName: String = ""

    @SerializedName("gender")
    var gender: String = ""

    @SerializedName("last_name")
    var lastName: String = ""

    @SerializedName("lat")
    var lat: Double = 0.0

    @SerializedName("lng")
    var lng: Double = 0.0

    @SerializedName("region")
    var region: Int = 0
}