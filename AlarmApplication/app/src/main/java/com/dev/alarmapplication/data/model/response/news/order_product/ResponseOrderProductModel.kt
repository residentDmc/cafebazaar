package com.dev.alarmapplication.data.model.response.news.order_product


import com.google.gson.annotations.SerializedName

data class ResponseOrderProductModel(
    @SerializedName("orderProductList")
    val orderProductList: List<OrderProduct>
)