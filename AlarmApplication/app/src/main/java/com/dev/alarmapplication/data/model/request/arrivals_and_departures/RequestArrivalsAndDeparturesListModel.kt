package com.dev.alarmapplication.data.model.request.arrivals_and_departures


import com.google.gson.annotations.SerializedName

class RequestArrivalsAndDeparturesListModel{
    @SerializedName("user_id")
    var userId: String=""
    @SerializedName("date_start")
    var dateStart: String=""
    @SerializedName("date_end")
    var dateEnd: String=""
    @SerializedName("state")
    var page: Int=-1
    var totalPage=-1
    var loading: Boolean=false
}