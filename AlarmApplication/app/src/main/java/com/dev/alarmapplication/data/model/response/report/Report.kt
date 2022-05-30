package com.dev.alarmapplication.data.model.response.report


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.USER_REPORT_ENTITY

@Entity(tableName = USER_REPORT_ENTITY)
class Report {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids")
    @NonNull
    var ids: Long = 0


    @SerializedName("date")
    @ColumnInfo(name = "date")
    var date: Long = 0

    @SerializedName("date_report")
    @ColumnInfo(name = "date_report")
    var dateReport: Long = 0

    @SerializedName("desc")
    @ColumnInfo(name = "desc")
    var desc: String= ""

    @SerializedName("condition")
    @ColumnInfo(name = "condition")
    var condition: String = ""

    @SerializedName("type")
    @ColumnInfo(name = "type")
    var type: String = ""

    @SerializedName("user_id")
    @ColumnInfo(name = "user_id")
    var userId: Int = 0


    @SerializedName("state")
    @ColumnInfo(name = "state")
    var state: Int = 0
}