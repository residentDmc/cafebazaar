package com.dev.alarmapplication.data.model.response.type_leave


import com.google.gson.annotations.SerializedName

data class ResponseTypeLeaveModel(
    @SerializedName("typeLeaveList")
    val typeLeaveList: List<TypeLeave>
)