package com.dev.alarmapplication.data.model.response.dashboard


import com.google.gson.annotations.SerializedName

data class ResponseDashboardModel(
    @SerializedName("home_data")
    val homeDataList: List<HomeData>
)