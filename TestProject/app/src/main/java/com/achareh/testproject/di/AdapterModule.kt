package com.achareh.testproject.di

import com.achareh.testproject.ui.view.adapter.address.AddressAdapter
import org.koin.dsl.module

val adapterModule = module {
    single { AddressAdapter(get()) }
}