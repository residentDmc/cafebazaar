package com.achareh.testproject.data.model.response.address_list


import com.google.gson.annotations.SerializedName

data class CityObject(
    @SerializedName("city_id")
    val cityId: Int,
    @SerializedName("city_name")
    val cityName: String
)