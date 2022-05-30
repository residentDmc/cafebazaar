package com.dev.alarmapplication.data.model.response.city_shop


import com.google.gson.annotations.SerializedName

data class ResponseCityShopModel(
    @SerializedName("city_shop")
    val cityShop: List<CityShop>
)