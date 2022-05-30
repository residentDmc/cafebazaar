package com.dev.alarmapplication.data.model.response.delete_requst_customer


import com.google.gson.annotations.SerializedName

data class ResponseDeleteRequestCustomerModel(
    @SerializedName("state")
    val state: String,
    @SerializedName("text")
    val text: String
)