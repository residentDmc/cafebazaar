package com.dev.alarmapplication.di

import com.dev.alarmapplication.ui.view.adapter.report.ReportAdapter
import org.koin.dsl.module


val adapterModule = module {
    single { ReportAdapter(get()) }
}