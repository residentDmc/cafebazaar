package com.dev.alarmapplication.data.model.response.list_leave


import com.google.gson.annotations.SerializedName

data class ResponseListLeaveAndMissionModel(
    @SerializedName("Leave")
    val leave: List<Leave>,
    @SerializedName("Mission")
    val mission: List<Mission>
)