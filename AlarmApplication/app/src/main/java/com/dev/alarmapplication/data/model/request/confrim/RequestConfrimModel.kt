package com.dev.alarmapplication.data.model.request.confrim


import com.google.gson.annotations.SerializedName

class RequestConfrimModel{
    @SerializedName("id")
    var id: Int=-1
    @SerializedName("type")
    var type: String=""
    @SerializedName("email")
    var email: String=""
    @SerializedName("desc_manage")
    var descManage: String=""
    @SerializedName("user_id")
    var userId: Int=-1
    var isValid: Int=-1
}