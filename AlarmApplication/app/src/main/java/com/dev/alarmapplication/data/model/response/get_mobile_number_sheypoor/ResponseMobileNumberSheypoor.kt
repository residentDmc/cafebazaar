package com.dev.alarmapplication.data.model.response.get_mobile_number_sheypoor


import com.google.gson.annotations.SerializedName

data class ResponseMobileNumberSheypoor(
    @SerializedName("chatNotifications")
    val chatNotifications: Int,
    @SerializedName("chatid")
    val chatid: String,
    @SerializedName("codesharzh")
    val codesharzh: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("emailAddress")
    val emailAddress: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("irancell")
    val irancell: Int,
    @SerializedName("isChatEnabled")
    val isChatEnabled: Int,
    @SerializedName("mci")
    val mci: Int,
    @SerializedName("mobileNumber")
    val mobileNumber: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("notificationKey")
    val notificationKey: String,
    @SerializedName("rightel")
    val rightel: Int,
    @SerializedName("test")
    val test: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("userid")
    val userid: String,
    @SerializedName("x_ticket")
    val xTicket: String
)