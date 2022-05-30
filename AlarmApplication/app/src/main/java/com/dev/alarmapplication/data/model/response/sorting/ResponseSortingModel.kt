package com.dev.alarmapplication.data.model.response.sorting


import com.google.gson.annotations.SerializedName

data class ResponseSortingModel(
    @SerializedName("sorting")
    val sorting: List<Sorting>
)