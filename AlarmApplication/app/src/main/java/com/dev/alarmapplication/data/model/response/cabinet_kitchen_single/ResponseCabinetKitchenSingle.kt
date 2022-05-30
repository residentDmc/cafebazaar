package com.dev.alarmapplication.data.model.response.cabinet_kitchen_single


import com.google.gson.annotations.SerializedName

data class ResponseCabinetKitchenSingle(
    @SerializedName("aerial_depth")
    val aerialDepth: Int,
    @SerializedName("aerial_height")
    val aerialHeight: Int,
    @SerializedName("base")
    val base: Int,
    @SerializedName("color")
    val color: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_all")
    val descriptionAll: String,
    @SerializedName("discount_price")
    val discountPrice: String?,
    @SerializedName("ground_depth")
    val groundDepth: Int,
    @SerializedName("ground_height")
    val groundHeight: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: String,
    @SerializedName("images_alt")
    val imagesAlt: String,
    @SerializedName("img_first")
    val imgFirst: String,
    @SerializedName("img_first_alt")
    val imgFirstAlt: String,
    @SerializedName("knobs")
    val knobs: Int,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("model")
    val model: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("piece")
    val piece: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("screen")
    val screen:  String?,
    @SerializedName("screen_depth")
    val screenDepth:  Double?,
    @SerializedName("size")
    val size: String,
    @SerializedName("thickness")
    val thickness: Double?,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("valid_piece")
    val validPiece: Int
)