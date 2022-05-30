package com.dev.alarmapplication.data.api.shaypoor

import com.dev.alarmapplication.data.model.request.add_ads.RequestAddAdsModel
import com.dev.alarmapplication.utils.build_config.BuildConfig
import okhttp3.MultipartBody
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.Part

interface ApiShaypoorHelper {

    suspend fun initMyAdsActiveShaypoor(xTicket:String, q: String): Any

    suspend fun initMyAdsInActiveShaypoor(xTicket:String, q: String): Any

    suspend fun initCreate(xTicket:String, it: RequestAddAdsModel): Any

    suspend fun initEditAds(xTicket:String, it: RequestAddAdsModel,leasing:String): Any

    suspend fun initInformationAds(xTicket:String,ids:String): Any

    suspend fun initRemoveAds(xTicket:String,ids:String): Any

    suspend fun initUploadImage(name: String,
                                fileName: String,
                                image: MultipartBody.Part ): Any

    suspend fun initAllCity(): Any


}
