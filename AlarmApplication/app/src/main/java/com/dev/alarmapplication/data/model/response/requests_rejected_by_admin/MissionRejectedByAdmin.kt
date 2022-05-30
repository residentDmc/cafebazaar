package com.dev.alarmapplication.data.model.response.requests_rejected_by_admin


import com.google.gson.annotations.SerializedName

data class MissionRejectedByAdmin(
    @SerializedName("address")
    val address: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("desc_manage")
    val descManage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isvalid")
    val isvalid: Int,
    @SerializedName("state")
    val state: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)