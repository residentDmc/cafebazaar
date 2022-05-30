package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class Sub(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_check")
    val idCheck: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String
)