package com.dev.alarmapplication.data.model.response.mobile_view_sheypoor


import com.google.gson.annotations.SerializedName

data class MobileViewSheypoorlistModelItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("test")
    val test: Int,
    @SerializedName("mobileNumber")
    val mobileNumber: String
)