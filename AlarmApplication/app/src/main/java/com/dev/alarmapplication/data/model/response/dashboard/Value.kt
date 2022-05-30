package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("banner")
    val banner: Banner,
    @SerializedName("header")
    val header: Header,
    @SerializedName("products")
    val categoryList: List<Category>,
    @SerializedName("sub_list")
    val subList: List<Sub>,
    @SerializedName("type")
    val type: String
)