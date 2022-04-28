package com.achareh.testproject.data.model.response.address_list


import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("city_object")
    val cityObject: CityObject,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("state_object")
    val stateObject: StateObject
)