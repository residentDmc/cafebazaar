package com.dev.alarmapplication.data.model.response.news.order_product


import com.google.gson.annotations.SerializedName

data class OrderProduct(
    @SerializedName("failed_at")
    val failedAt: String,
    @SerializedName("approval_at")
    val approvalAt: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("information")
    val information: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("description_failed")
    val descriptionFailed: String
)