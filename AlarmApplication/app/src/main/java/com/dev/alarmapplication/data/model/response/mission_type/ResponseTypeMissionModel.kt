package com.dev.alarmapplication.data.model.response.mission_type


import com.google.gson.annotations.SerializedName

data class ResponseTypeMissionModel(
    @SerializedName("typeLeaveList")
    val typeLeaveList: List<TypeMission>
)