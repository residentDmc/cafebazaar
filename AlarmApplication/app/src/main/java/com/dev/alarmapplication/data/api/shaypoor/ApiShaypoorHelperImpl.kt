package com.dev.alarmapplication.data.api.shaypoor

import com.dev.alarmapplication.data.model.request.add_ads.RequestAddAdsModel
import okhttp3.MultipartBody

class ApiShaypoorHelperImpl(private val apiShaypoorService: ApiShaypoorService) : ApiShaypoorHelper {

    override suspend fun initMyAdsActiveShaypoor(xTicket:String,q: String): Any =
        try {
            apiShaypoorService.initMyAdsActiveShaypoor(xTicket,q)
        } catch (e: Exception) {
            e
        }

    override suspend fun initMyAdsInActiveShaypoor(xTicket: String, q: String):  Any =
        try {
            apiShaypoorService.initMyAdsInActiveShaypoor(xTicket,q)
        } catch (e: Exception) {
            e
        }

    override suspend fun initCreate(xTicket:String, it: RequestAddAdsModel): Any =
        try {
            apiShaypoorService.initCreate(xTicket,it)
        } catch (e: Exception) {
            e
        }

    override suspend fun initEditAds(xTicket: String, it: RequestAddAdsModel,leasing:String): Any =
        try {
            apiShaypoorService.initEditAds(xTicket,it,leasing)
        } catch (e: Exception) {
            e
        }

    override suspend fun initInformationAds(xTicket: String, ids: String): Any =
        try {
            apiShaypoorService.initInformationAds(xTicket,ids)
        } catch (e: Exception) {
            e
        }

    override suspend fun initRemoveAds(xTicket: String, ids: String): Any =
        try {
            apiShaypoorService.initRemoveAds(xTicket,ids)
        } catch (e: Exception) {
            e
        }

    override suspend fun initUploadImage(
        name: String,
        fileName: String,
        image: MultipartBody.Part
    ):Any =
        try {
            apiShaypoorService.initUploadImage(name, fileName, image)
        } catch (e: Exception) {
            e
        }

    override suspend fun initAllCity(): Any =
        try {
            apiShaypoorService.initAllCity()
        } catch (e: Exception) {
            e
        }
}