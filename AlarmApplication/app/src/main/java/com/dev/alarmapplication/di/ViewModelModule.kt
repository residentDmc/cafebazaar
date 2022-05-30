package com.dev.alarmapplication.di

import com.dev.alarmapplication.ui.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { UserViewModel(get()) }
    viewModel { AlarmViewModel(get()) }
}