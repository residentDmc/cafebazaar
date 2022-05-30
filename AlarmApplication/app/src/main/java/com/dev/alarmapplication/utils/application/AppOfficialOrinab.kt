package com.dev.alarmapplication.utils.application

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.mapbox.mapboxsdk.Mapbox
import com.dev.alarmapplication.R
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone
import com.dev.alarmapplication.data.room.UserDatabase
import com.dev.alarmapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


open class AppOfficialOrinab : MultiDexApplication() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var activity: Activity
        var user: User?=null

        lateinit var verificationRegisterPhone: VerificationRegisterPhone

        fun initUser(): User? {
            if (user==null)
                user = UserDatabase.getInstance().userDAO().getUserLocal()
            return user
        }

        fun initVerificationRegisterPhone(): VerificationRegisterPhone? =
            UserDatabase.getInstance().userDAO().getVerificationRegisterPhoneLocal()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        //CrashConfig.Builder.create().apply()
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        context = this
        startKoin {
            androidContext(context)
            modules(listOf(appModule, adapterModule, repoModule, viewModelModule, DatabaseModule))
        }
    }
}