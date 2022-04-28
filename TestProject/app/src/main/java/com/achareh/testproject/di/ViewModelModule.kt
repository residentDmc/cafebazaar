package com.achareh.testproject.di

import com.achareh.testproject.ui.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { DashboardViewModel(get()) }
    viewModel { MapIrViewModel(get()) }
}