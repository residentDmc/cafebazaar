package com.achareh.testproject.di

import com.achareh.testproject.data.repository.*
import org.koin.dsl.module

val repoModule = module {

    single { DashboardRepository(get()) }
    single { MapIrRepository(get()) }

}