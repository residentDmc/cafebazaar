package com.dev.alarmapplication.data.model.response.account_shaypoor


import com.google.gson.annotations.SerializedName

data class AccountSheypoor(
    @SerializedName("chat_id")
    val chatId: String,
    @SerializedName("first_token")
    val firstToken: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("mobileNumber")
    val mobileNumber: String,
    @SerializedName("userID")
    val userID: String,
    @SerializedName("x-ticket")
    val xTicket: String
)