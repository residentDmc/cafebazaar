package com.dev.alarmapplication.data.model.response.address_map_ir


import com.google.gson.annotations.SerializedName

data class Geom(
    @SerializedName("coordinates")
    val coordinates: List<String>,
    @SerializedName("type")
    val type: String
)