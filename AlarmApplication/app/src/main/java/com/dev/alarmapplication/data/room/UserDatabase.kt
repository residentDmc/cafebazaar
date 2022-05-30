package com.dev.alarmapplication.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.alarmapplication.data.model.request.location.SaveLocationModel
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone
import com.dev.alarmapplication.utils.application.AppOfficialOrinab
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.USER_DATABASE

@Database(entities = [User::class, Report::class, VerificationRegisterPhone::class, SaveLocationModel::class], version = 13, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        private var instance: UserDatabase? = null
        fun getInstance(): UserDatabase {
            if (instance == null) {

                instance = Room.databaseBuilder(AppOfficialOrinab.context.applicationContext,
                    UserDatabase::class.java,
                    USER_DATABASE)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }
    }

}