package com.dev.alarmapplication.data.model.response.address_map_ir


import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.data.model.response.address_map_ir.Geom

data class ResponseAddressMapIrModel(
    @SerializedName("address")
    val address: String,
    @SerializedName("address_compact")
    val addressCompact: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("county")
    val county: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("geom")
    val geom: Geom,
    @SerializedName("last")
    val last: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("neighbourhood")
    val neighbourhood: String,
    @SerializedName("plaque")
    val plaque: String,
    @SerializedName("poi")
    val poi: String,
    @SerializedName("postal_address")
    val postalAddress: String,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("province")
    val province: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("rural_district")
    val ruralDistrict: String,
    @SerializedName("village")
    val village: String
)