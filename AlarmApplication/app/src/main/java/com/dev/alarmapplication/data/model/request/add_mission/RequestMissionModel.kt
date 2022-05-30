package com.dev.alarmapplication.data.model.request.add_mission


import com.google.gson.annotations.SerializedName

class RequestMissionModel{
    @SerializedName("id")
    var id: Int=-1
    @SerializedName("type")
    var type: String=""
    @SerializedName("email")
    var email: String=""
    @SerializedName("date")
    var date: String=""
    @SerializedName("desc")
    var desc: String=""
    @SerializedName("state")
    var state: Int=-1
    var isValid: Int=-1
    var stateTitle:String=""
    var address:String=""
    @SerializedName("user_id")
    var userId: Int=-1
}