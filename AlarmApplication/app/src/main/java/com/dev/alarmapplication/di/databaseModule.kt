package com.dev.alarmapplication.di

import com.dev.alarmapplication.data.room.UserDatabase
import org.koin.dsl.module


val DatabaseModule = module {
    single { UserDatabase.getInstance() }
}