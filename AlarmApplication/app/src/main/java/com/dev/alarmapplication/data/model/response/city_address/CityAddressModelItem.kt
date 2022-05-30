package com.dev.alarmapplication.data.model.response.city_address


import com.google.gson.annotations.SerializedName

data class CityAddressModelItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("tell")
    val tell: String,
    @SerializedName("updated_at")
    val updatedAt: String
)