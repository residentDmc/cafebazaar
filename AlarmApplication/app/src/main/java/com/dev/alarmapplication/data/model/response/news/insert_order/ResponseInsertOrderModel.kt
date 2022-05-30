package com.dev.alarmapplication.data.model.response.news.insert_order


import com.google.gson.annotations.SerializedName

data class ResponseInsertOrderModel(
    @SerializedName("product_name")
    val productName: List<ProductName>,
    @SerializedName("barcode")
    val barcode: List<Barcode>,
    @SerializedName("color")
    val color: List<ColorItem>
)