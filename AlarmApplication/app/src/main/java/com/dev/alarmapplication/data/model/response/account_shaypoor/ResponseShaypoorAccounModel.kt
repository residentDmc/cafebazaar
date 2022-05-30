package com.dev.alarmapplication.data.model.response.account_shaypoor


import com.google.gson.annotations.SerializedName

data class ResponseShaypoorAccounModel(
    @SerializedName("account_shaypoor")
    val accountShaypoor: List<AccountSheypoor>
)