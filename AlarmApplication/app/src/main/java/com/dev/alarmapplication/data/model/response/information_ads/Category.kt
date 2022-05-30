package com.dev.alarmapplication.data.model.response.information_ads


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("c1")
    val c1: String,
    @SerializedName("c2")
    val c2: String,
    @SerializedName("c3")
    val c3: Any,
    @SerializedName("categoryID")
    val categoryID: Int,
    @SerializedName("rootCategoryId")
    val rootCategoryId: Int
)