package com.dev.alarmapplication.data.api.shaypoor

import com.dev.alarmapplication.data.model.request.add_ads.RequestAddAdsModel
import com.dev.alarmapplication.data.model.response.add_ads_sheypoor.ResponseAddAdsModel
import com.dev.alarmapplication.data.model.response.information_ads.ResponseInformationAdsModel
import com.dev.alarmapplication.data.model.response.location_shaypoor.ResponseLocationShaypoorModel
import com.dev.alarmapplication.data.model.response.my_ads_shaypoor.ResponseMyAdsShaypoorModel
import com.dev.alarmapplication.data.model.response.remove_ads_sheypoor.ResponseRemoveAdsSheypoorModel
import com.dev.alarmapplication.data.model.response.response_upload_image.ResponseUploadImageModel
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ALL_CITY
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.CREATE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.EDIT_ADS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.FILE_NAME
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IDS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IMAGE_UPLOAD
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.INFO_ADS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.MY_ADS_ACTIVE_SHAYPOOR
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.MY_ADS_IN_ACTIVE_SHAYPOOR
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.NAME
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.Q
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REMOVE_ADS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.X_TICKET
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiShaypoorService {

    @GET(MY_ADS_ACTIVE_SHAYPOOR)
    suspend fun initMyAdsActiveShaypoor(@Header(X_TICKET) xTicket: String, @Query(Q) q: String): ResponseMyAdsShaypoorModel

    @GET(MY_ADS_IN_ACTIVE_SHAYPOOR)
    suspend fun initMyAdsInActiveShaypoor(@Header(X_TICKET) xTicket: String, @Query(Q) q: String): ResponseMyAdsShaypoorModel

    @POST(CREATE)
    suspend fun initCreate(@Header(X_TICKET) xTicket: String, @Body requestAddAdsModel: RequestAddAdsModel): ResponseAddAdsModel

    @PUT(EDIT_ADS)
    suspend fun initEditAds(@Header(X_TICKET) xTicket: String, @Body requestAddAdsModel: RequestAddAdsModel,@Path(IDS) leasing:String): ResponseAddAdsModel

    @GET(INFO_ADS)
    suspend fun initInformationAds(@Header(X_TICKET) xTicket: String, @Path(IDS) ids:String): ResponseInformationAdsModel

    @DELETE(REMOVE_ADS)
    suspend fun initRemoveAds(@Header(X_TICKET) xTicket: String, @Path(IDS) ids:String): ResponseRemoveAdsSheypoorModel

    @Multipart
    @POST(IMAGE_UPLOAD)
    suspend fun initUploadImage(@Part(NAME) name: String
                           , @Part(FILE_NAME) fileName: String
                           , @Part image: MultipartBody.Part ): ResponseUploadImageModel

    @GET(ALL_CITY)
    suspend fun initAllCity(): ResponseLocationShaypoorModel


}