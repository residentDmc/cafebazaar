package com.dev.alarmapplication.data.model.response.response_upload_image


import com.google.gson.annotations.SerializedName

data class ResponseUploadImageModel(
    @SerializedName("imageKey")
    val imageKey: String,
    @SerializedName("imageSize")
    val imageSize: Int
)