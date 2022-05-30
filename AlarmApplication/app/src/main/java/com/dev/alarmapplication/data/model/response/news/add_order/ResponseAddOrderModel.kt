package com.dev.alarmapplication.data.model.response.news.add_order


import com.google.gson.annotations.SerializedName

data class ResponseAddOrderModel(
    @SerializedName("orderList")
    val orderList: List<Order>
)