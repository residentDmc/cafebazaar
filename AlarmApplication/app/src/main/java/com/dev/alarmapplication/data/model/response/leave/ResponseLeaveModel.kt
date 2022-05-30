package com.dev.alarmapplication.data.model.response.leave


import com.google.gson.annotations.SerializedName

data class ResponseLeaveModel(
    @SerializedName("leaveList")
    val leaveList: List<Leave>
)