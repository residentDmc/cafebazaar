package com.dev.alarmapplication.data.model.request.login


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.utils.build_config.BuildConfig

@Entity(tableName = BuildConfig.USER_ENTITY)
class User{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids")
    @NonNull
    var ids: Int = -1
    @SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String=""
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int=-1
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String=""
    @SerializedName("role_id")
    @ColumnInfo(name = "role_ids")
    var roleIds: Int=-1
    @SerializedName("token")
    @ColumnInfo(name = "token")
    var token: String=""
    @ColumnInfo(name = "token_firebase")
    var tokenFirebase: String?=""

    fun initBearerToken():String = "Bearer $token"

}