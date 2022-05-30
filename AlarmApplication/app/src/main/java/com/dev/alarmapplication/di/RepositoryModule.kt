package com.dev.alarmapplication.di

import com.dev.alarmapplication.data.repository.*
import org.koin.dsl.module

val repoModule = module {
    single { UserRepository(get()) }
    single { AlarmRepository() }

}