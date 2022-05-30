package com.dev.alarmapplication.di

import android.content.Context
import android.media.MediaPlayer
import androidx.navigation.Navigation
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.dev.alarmapplication.BuildConfig.DEBUG
import com.dev.alarmapplication.R
import com.dev.alarmapplication.data.api.ApiHelper
import com.dev.alarmapplication.data.api.ApiHelperImpl
import com.dev.alarmapplication.data.api.ApiService
import com.dev.alarmapplication.data.api.open_street_map.ApiMapIrHelper
import com.dev.alarmapplication.utils.application.AppOfficialOrinab.Companion.activity
import com.dev.alarmapplication.utils.application.AppOfficialOrinab.Companion.context
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BASE_URL
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BASE_URL_MAP_IR

import com.dev.alarmapplication.utils.image.ZoomOutSlideTransformer
import com.dev.alarmapplication.utils.manager.GridLayoutCountManager
import com.dev.alarmapplication.utils.manager.KeyboardManager
import com.dev.alarmapplication.utils.music_manager.BeatBox
import com.dev.alarmapplication.utils.network_helper.NetworkHelper
import com.dev.alarmapplication.utils.tools.*
import com.dev.alarmapplication.utils.type_converters.ToStringConverterFactory
import com.dev.alarmapplication.data.api.open_street_map.ApiMapIrHelperImpl
import com.dev.alarmapplication.data.api.open_street_map.ApiMapIrService
import com.dev.alarmapplication.data.api.register_phone.ApiHelperRegisterPhone
import com.dev.alarmapplication.data.api.register_phone.ApiHelperRegisterPhoneImpl
import com.dev.alarmapplication.data.api.register_phone.ApiServiceRegisterPhone
import com.dev.alarmapplication.data.api.shaypoor.ApiShaypoorHelper
import com.dev.alarmapplication.data.api.shaypoor.ApiShaypoorHelperImpl
import com.dev.alarmapplication.data.api.shaypoor.ApiShaypoorService
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BASE_URL_REGISTER_PHONE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BASE_URL_SHAYPOOR
import com.dev.alarmapplication.utils.image_picker.ImagePicker
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    single { initNavController() }
    single { return@single ThrowableTools(get(), get()) }
    single { return@single Gson() }
    single { return@single ToastTools() }
    single { return@single GlideTools(get(), get()) }
    single { return@single HandleErrorTools() }
    single { return@single GridLayoutCountManager(get()) }
    single { return@single ToStringConverterFactory() }
    single { return@single KeyboardManager() }
    single { return@single NetworkTools() }
    single { return@single BottomSheetDialog(activity) }
    single { return@single ZoomOutSlideTransformer() }
    single { return@single BeatBox(get(), get()) }
    single { return@single MediaPlayer() }
    single { return@single SplitterTools() }
    single { return@single ImagePicker() }
}

private fun initNavController() =
    Navigation.findNavController(activity, R.id.my_nav_fragment)
