package com.dev.alarmapplication.data.model.response.view_mile


import com.google.gson.annotations.SerializedName

data class ResponseViewMileModel(
    @SerializedName("Leave")
    val viewMileLeave: List<ViewMileLeave>,
    @SerializedName("Mission")
    val viewMileMission: List<ViewMileMission>
)