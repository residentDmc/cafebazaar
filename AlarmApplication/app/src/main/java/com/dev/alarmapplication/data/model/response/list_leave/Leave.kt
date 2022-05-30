package com.dev.alarmapplication.data.model.response.list_leave


import com.google.gson.annotations.SerializedName

data class Leave(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("date_end")
    val dateEnd: String,
    @SerializedName("date_start")
    val dateStart: String,
    @SerializedName("deleted_at")
    val deletedAt: String,
    @SerializedName("desc")
    val desc: String?,
    @SerializedName("desc_manage")
    val descManage: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isvalid")
    val isValid: Int,
    @SerializedName("state")
    val state: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)