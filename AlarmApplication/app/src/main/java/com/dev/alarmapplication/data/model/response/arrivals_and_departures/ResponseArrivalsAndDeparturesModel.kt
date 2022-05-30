package com.dev.alarmapplication.data.model.response.arrivals_and_departures


import com.google.gson.annotations.SerializedName

data class ResponseArrivalsAndDeparturesModel(
    @SerializedName("response")
    val response: Response
)