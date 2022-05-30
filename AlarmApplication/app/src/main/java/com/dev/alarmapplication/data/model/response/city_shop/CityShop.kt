package com.dev.alarmapplication.data.model.response.city_shop


import com.google.gson.annotations.SerializedName

data class CityShop(
    @SerializedName("shop_list")
    val shopList: List<Shop>,
    @SerializedName("title")
    val title: String
)