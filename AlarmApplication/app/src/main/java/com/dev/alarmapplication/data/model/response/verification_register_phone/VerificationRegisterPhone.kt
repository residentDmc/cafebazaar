package com.dev.alarmapplication.data.model.response.verification_register_phone


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.utils.build_config.BuildConfig
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REGISTER_PHONE_ENTITY

@Entity(tableName = REGISTER_PHONE_ENTITY)
class VerificationRegisterPhone{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids")
    @NonNull
    var ids: Int = -1

    @SerializedName("check")
    var check: Int=-1
    @SerializedName("id")
    var id: Int=-1
    @SerializedName("op")
    var op: String=""
    @SerializedName("role_id")
    var roleId: Int=-1
    @SerializedName("username")
    var mobile: String=""
    @SerializedName("token")
    var token: String=""
    
}