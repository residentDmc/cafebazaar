package com.achareh.testproject.utils.application

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.achareh.testproject.R
import com.achareh.testproject.di.adapterModule
import com.achareh.testproject.di.appModule
import com.achareh.testproject.di.repoModule
import com.achareh.testproject.di.viewModelModule
import com.mapbox.mapboxsdk.Mapbox
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppTestProject : MultiDexApplication() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var activity: Activity
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        context = this
        startKoin {
            androidContext(context)
            modules(listOf(appModule, adapterModule, repoModule, viewModelModule))
        }
    }
}