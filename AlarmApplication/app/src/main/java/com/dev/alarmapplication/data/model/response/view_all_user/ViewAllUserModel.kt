package com.dev.alarmapplication.data.model.response.view_all_user


import com.google.gson.annotations.SerializedName

data class ViewAllUserModel(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("check")
    val check: Any,
    @SerializedName("checkexpirydate")
    val checkexpirydate: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("op")
    val op: Any,
    @SerializedName("role_id")
    val roleId: Int,
    @SerializedName("settings")
    val settings: Settings,
    @SerializedName("tell")
    val tell: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: Any
){
    var dateStart:String?=""
    var dateEnd:String?=""
}