package com.dev.alarmapplication.data.model.request.location

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.dev.alarmapplication.utils.build_config.BuildConfig
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.SAVE_LOCATION_ENTITY

@Entity(tableName = SAVE_LOCATION_ENTITY)
class SaveLocationModel{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ids")
    @NonNull
    var ids: Long = 0

    @SerializedName("date")
    @ColumnInfo(name = "date")
    var date: String=""

    @SerializedName("location")
    @ColumnInfo(name = "location")
    var location: String=""


}