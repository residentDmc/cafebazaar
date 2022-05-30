package com.dev.alarmapplication.data.model.response.news.add_order


import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("information")
    val information: List<Information>,
    @SerializedName("title")
    val title: String
)