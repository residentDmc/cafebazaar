package com.dev.alarmapplication.data.model.response.login_register_phone


import com.google.gson.annotations.SerializedName

data class ResponseLoginRegisterPhoneModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String
)