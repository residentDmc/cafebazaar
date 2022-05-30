package com.dev.alarmapplication.data.model.request.add_leave


import com.google.gson.annotations.SerializedName

class RequestAddLeaveModel{
    @SerializedName("id")
    var id: Int=-1
    @SerializedName("type")
    var type: String=""
    @SerializedName("email")
    var email: String=""
    @SerializedName("date_start")
    var dateStart: String=""
    @SerializedName("date_end")
    var dateEnd: String=""
    @SerializedName("desc")
    var desc: String=""
    @SerializedName("state")
    var state: Int=-1
    var isValid: Int=-1
    var stateTitle:String=""
    @SerializedName("user_id")
    var userId: Int=-1
}