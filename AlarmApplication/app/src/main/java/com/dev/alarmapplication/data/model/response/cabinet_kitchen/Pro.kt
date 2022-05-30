package com.dev.alarmapplication.data.model.response.cabinet_kitchen


import com.google.gson.annotations.SerializedName

data class Pro(
    @SerializedName("color")
    val color: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("discount_price")
    val discountPrice: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_first")
    val imgFirst: String,
    @SerializedName("img_first_alt")
    val imgFirstAlt: String,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("model")
    val model: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("valid_piece")
    val validPiece: Int
)