package com.dev.alarmapplication.data.model.response.cabinet_kitchen


import com.google.gson.annotations.SerializedName

data class TIT(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("desc")
    val desc: Int,
    @SerializedName("desk")
    val desk: String,
    @SerializedName("h1")
    val h1: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("meta_desc")
    val metaDesc: String,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String
)