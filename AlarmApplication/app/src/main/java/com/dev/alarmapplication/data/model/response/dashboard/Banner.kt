package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_check")
    val idCheck: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("tittle")
    val tittle: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("video")
    val video: String
)