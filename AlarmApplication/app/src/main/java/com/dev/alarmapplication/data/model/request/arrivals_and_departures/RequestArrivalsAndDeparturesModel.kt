package com.dev.alarmapplication.data.model.request.arrivals_and_departures


import com.google.gson.annotations.SerializedName

class RequestArrivalsAndDeparturesModel{
    @SerializedName("address")
    var address: String=""
    @SerializedName("date")
    var date: String=""
    @SerializedName("desc")
    var desc: String=""
    @SerializedName("location")
    var location: String=""
    @SerializedName("state")
    var state: Int=-1
    @SerializedName("user_id")
    var userId: Int=-1
}