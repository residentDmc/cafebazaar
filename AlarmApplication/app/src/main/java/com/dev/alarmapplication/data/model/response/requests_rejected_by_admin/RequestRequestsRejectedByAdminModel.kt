package com.dev.alarmapplication.data.model.response.requests_rejected_by_admin


import com.google.gson.annotations.SerializedName

data class RequestRequestsRejectedByAdminModel(
    @SerializedName("Leave")
    val leaveRejectedByAdmin: List<LeaveRejectedByAdmin>,
    @SerializedName("Mission")
    val missionRejectedByAdmin: List<MissionRejectedByAdmin>
)