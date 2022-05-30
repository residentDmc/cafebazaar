package com.dev.alarmapplication.data.model.response.leave


import com.google.gson.annotations.SerializedName

data class Leave(
    @SerializedName("condition")
    val condition: Int,
    @SerializedName("date_of_leave_request")
    val dateOfLeaveRequest: String,
    @SerializedName("date_of_request_submission")
    val dateOfRequestSubmission: String
)