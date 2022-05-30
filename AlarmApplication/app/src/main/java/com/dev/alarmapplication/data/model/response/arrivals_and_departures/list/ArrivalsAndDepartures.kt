package com.dev.alarmapplication.data.model.response.arrivals_and_departures.list


import com.google.gson.annotations.SerializedName

data class ArrivalsAndDepartures(
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
    val descManage: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("state")
    val state: Int,
    @SerializedName("tarikh")
    val tarikh: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
){
    var type: String?=""
}