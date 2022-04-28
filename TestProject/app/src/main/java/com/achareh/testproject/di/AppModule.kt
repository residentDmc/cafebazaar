package com.achareh.testproject.di

import android.content.Context
import android.media.MediaPlayer
import com.achareh.testproject.BuildConfig.DEBUG
import com.achareh.testproject.data.api.achare.ApiHelper
import com.achareh.testproject.data.api.achare.ApiHelperImpl
import com.achareh.testproject.data.api.achare.ApiService
import com.achareh.testproject.data.api.open_street_map.ApiMapIrHelper
import com.achareh.testproject.data.api.open_street_map.ApiMapIrHelperImpl
import com.achareh.testproject.data.api.open_street_map.ApiMapIrService
import com.achareh.testproject.utils.application.AppTestProject.Companion.activity
import com.achareh.testproject.utils.application.AppTestProject.Companion.context
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.AUTHORIZATION
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.AUTHORIZATION_PASSWORD
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.AUTHORIZATION_USER_NAME
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.BASE_URL
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.BASE_URL_MAP_IR
import com.achareh.testproject.utils.manager.GridLayoutCountManager
import com.achareh.testproject.utils.manager.KeyboardManager
import com.achareh.testproject.utils.network_helper.NetworkHelper
import com.achareh.testproject.utils.tools.*
import com.achareh.testproject.utils.type_converters.ToStringConverterFactory
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import okhttp3.Credentials
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
    single { provideRetrofit(get(), get()) }
    single { provideRetrofitOpenStreetMap(get(), get()) }
    single { provideNetworkHelper(androidContext()) }
    single<ApiHelper> { return@single ApiHelperImpl(get()) }
    single<ApiMapIrHelper> { return@single ApiMapIrHelperImpl(get()) }
    single { return@single ThrowableTools(get(), get()) }
    single { return@single Gson() }
    single { return@single ToastTools() }
    single { return@single HandleErrorTools() }
    single { return@single GridLayoutCountManager(get()) }
    single { return@single ToStringConverterFactory() }
    single { return@single KeyboardManager() }
    single { return@single NetworkTools() }
    single { return@single BottomSheetDialog(activity) }
    single { return@single MediaPlayer() }
    single { provideOkHttpClient() }
}

fun provideNetworkHelper(context: Context) = NetworkHelper(context)

fun provideOkHttpClient(): OkHttpClient {
    val i = Interceptor { chain: Interceptor.Chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder().header(AUTHORIZATION, Credentials.basic(AUTHORIZATION_USER_NAME, AUTHORIZATION_PASSWORD))
        val request: Request = requestBuilder.build()
        val response = chain.proceed(request)
        response
    }
    val okHttpClient= OkHttpClient.Builder().writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).addInterceptor(i);
    if (DEBUG) {
        okHttpClient.addInterceptor(ChuckerInterceptor(context))
    }
    return okHttpClient.build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, toStringConverterFactory: ToStringConverterFactory): ApiService =
    Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(toStringConverterFactory)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)

fun provideRetrofitOpenStreetMap(okHttpClient: OkHttpClient, toStringConverterFactory: ToStringConverterFactory): ApiMapIrService =
    Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(toStringConverterFactory)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_MAP_IR)
        .client(okHttpClient)
        .build()
        .create(ApiMapIrService::class.java)
