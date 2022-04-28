package com.achareh.testproject.data.model.response.error


import com.google.gson.annotations.SerializedName

data class ResponseErrorModel(
    @SerializedName("detail")
    val detail: String
)