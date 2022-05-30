package com.dev.alarmapplication.data.api

import com.dev.alarmapplication.data.model.request.add_ad_divar_orinab.RequestAddAdDrivarOrinab
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.add_ads.ResponseAddAdsDivarOrinabModel
import com.dev.alarmapplication.data.model.response.add_leave.ResponseConfrimModel
import com.dev.alarmapplication.data.model.response.arrivals_and_departures.ResponseArrivalsAndDeparturesModel
import com.dev.alarmapplication.data.model.response.arrivals_and_departures.list.ResponseArrivalsAndDeparturesListModel
import com.dev.alarmapplication.data.model.response.delete_requst_customer.ResponseDeleteRequestCustomerModel
import com.dev.alarmapplication.data.model.response.get_location.ResponseGetLocationModel
import com.dev.alarmapplication.data.model.response.get_mobile_number_sheypoor.ResponseMobileNumberSheypoor
import com.dev.alarmapplication.data.model.response.list_leave.ResponseListLeaveAndMissionModel
import com.dev.alarmapplication.data.model.response.message.ResponseMessageModel
import com.dev.alarmapplication.data.model.response.mission.ResponseMissionModel
import com.dev.alarmapplication.data.model.response.mobile_view_sheypoor.ResponseMobileViewSheypoorlistModel
import com.dev.alarmapplication.data.model.response.requests_rejected_by_admin.RequestRequestsRejectedByAdminModel
import com.dev.alarmapplication.data.model.response.upload_image_divar_orinab.ResponseImageUploadDivarOrinabModel
import com.dev.alarmapplication.data.model.response.view_all_user.ResponseViewAllUserModel
import com.dev.alarmapplication.data.model.response.view_mile.ResponseViewMileModel
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ADDRESS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ADD_ARRIVALS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ADD_LEAVE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ADD_MISSION
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ADV_SUB
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.AUTHORIZATION
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DATE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DATE_END
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DATE_START
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DELETE_REQUEST_SINGLE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DESC
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DESC_MANAGE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.EDIT_REQUEST_SINGLE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.EDIT_REQUEST_SINGLE_CUSTOMER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.EMAIL
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.GET_LOCATION
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.GET_NUMBER_SHEYPOOR
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IDS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IMAGE_DELETE_DIRVAR_ORINAB
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IMAGE_NAME
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IMAGE_UPLOAD_DIRVAR_ORINAB
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IS_VALID
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LOCATION
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LOGIN
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LOG_USER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.MOBILE_VIEW_SHEYPOOR
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.PASSWORD
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.SAVE_LOCATION
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.SEND_TOKEN_FIREBASE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.STATE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.TOKEN_FIREBASE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.TYPE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.USER_ID
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_ALL_USER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_ARRIVALS_USER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_MILE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_MILE_FALSE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_MILE_SINGLE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_MILE_SINGLE_USER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.VIEW_MILE_TRUE
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @GET(MOBILE_VIEW_SHEYPOOR)
    suspend fun initMobileViewSheypoor(): ResponseMobileViewSheypoorlistModel

    @GET(GET_NUMBER_SHEYPOOR)
    suspend fun initGetNumberSheypoor(@Query(IDS) ids: String): ResponseMobileNumberSheypoor

    @POST(LOGIN)
    suspend fun intLogin(@Query(EMAIL) email: String, @Query(PASSWORD) password: String): User

    @POST(LOGIN)
    suspend fun intLogins(@Query(EMAIL) email: String, @Query(PASSWORD) password: String): User

    @POST(ADV_SUB)
    suspend fun initAdvSub(@Body requestAddAdDrivarOrinab: RequestAddAdDrivarOrinab): ResponseAddAdsDivarOrinabModel

    @Multipart
    @POST(IMAGE_UPLOAD_DIRVAR_ORINAB)
    suspend fun initUploadImageDivarOrinab(@Part image: MultipartBody.Part): ResponseImageUploadDivarOrinabModel

    @POST(IMAGE_DELETE_DIRVAR_ORINAB)
    suspend fun initDeleteImageDivarOrinab(@Field(IMAGE_NAME) image: String): String

    @POST(ADD_ARRIVALS)
    suspend fun intAddArrivals(
        @Query(DATE) date: String,
        @Query(ADDRESS) address: String,
        @Query(LOCATION) location: String,
        @Query(STATE) state: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC) desc: String
    ): ResponseArrivalsAndDeparturesModel

    @POST(ADD_MISSION)
    suspend fun intAddMission(
        @Query(DATE) date: String,
        @Query(ADDRESS) address: String,
        @Query(STATE) state: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC) desc: String
    ): ResponseMissionModel


    @POST(ADD_LEAVE)
    suspend fun intAddLeve(
        @Query(DATE_START) startDate: String,
        @Query(DATE_END) endDate: String,
        @Query(STATE) state: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC) desc: String
    ): ResponseConfrimModel


    @POST(EDIT_REQUEST_SINGLE_CUSTOMER)
    suspend fun intEditRequestSingleLeave(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(TYPE) type: String,
        @Query(EMAIL) email: String,
        @Query(IDS) id: Int,
        @Query(DATE_START) startDate: String,
        @Query(DATE_END) endDate: String,
        @Query(STATE) state: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC) desc: String
    ): ResponseConfrimModel

    @POST(DELETE_REQUEST_SINGLE)
    suspend fun initDeleteRequestSingleLeave(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(TYPE) type: String,
        @Query(EMAIL) email: String,
        @Query(IDS) id: Int,
        @Query(USER_ID) userId: Int
    ): ResponseDeleteRequestCustomerModel

    @POST(EDIT_REQUEST_SINGLE_CUSTOMER)
    suspend fun intEditRequestSingleMission(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(TYPE) type: String,
        @Query(EMAIL) email: String,
        @Query(IDS) id: Int,
        @Query(DATE) date: String,
        @Query(STATE) state: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC) desc: String
    ): ResponseMissionModel

    @POST(EDIT_REQUEST_SINGLE)
    suspend fun intEditRequestSingle(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(TYPE) type: String,
        @Query(EMAIL) email: String,
        @Query(IDS) id: Int,
        @Query(IS_VALID) isValid: Int,
        @Query(USER_ID) userId: Int,
        @Query(DESC_MANAGE) descManage: String
    ): ResponseConfrimModel

    @GET(VIEW_MILE_SINGLE)
    suspend fun intViewMileSingle(
        @Query(TYPE) type: String,
        @Query(IDS) id: Int
    ): ResponseListLeaveAndMissionModel

    @GET(VIEW_MILE_SINGLE_USER)
    suspend fun intViewMileSingleUser(@Query(USER_ID) id: Int): ResponseListLeaveAndMissionModel

    @POST(VIEW_MILE)
    suspend fun intViewMile(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(EMAIL) email: String
    ): ResponseViewMileModel

    @GET(VIEW_ARRIVALS_USER)
    suspend fun intViewArrivalsUser(
        @Query(DATE_START) startDate: String, @Query(DATE_END) endDate: String,
        @Query(USER_ID) userId: Int,
    ): ResponseArrivalsAndDeparturesListModel

    @GET(VIEW_ALL_USER)
    suspend fun intViewAllUser(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(EMAIL) email: String
    ): ResponseViewAllUserModel

    @POST(VIEW_MILE_FALSE)
    suspend fun initViewMiLeFalse(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(EMAIL) email: String
    ): RequestRequestsRejectedByAdminModel

    @POST(VIEW_MILE_TRUE)
    suspend fun initViewMiLeTrue(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(EMAIL) email: String
    ): RequestRequestsRejectedByAdminModel

    @FormUrlEncoded
    @POST(SAVE_LOCATION)
    suspend fun initSaveLocation(
        @Header(AUTHORIZATION) authHeader: String, @Query(USER_ID) userId: Int, @Query(DATE) date: String, @Field(LOCATION) location: String
    ): ResponseMessageModel

    @FormUrlEncoded
    @POST(SAVE_LOCATION)
    fun initSaveLocations(
        @Header(AUTHORIZATION) authHeader: String, @Query(USER_ID) userId: Int, @Query(DATE) date: String, @Field(LOCATION) location: String
    ): Call<ResponseMessageModel?>?

    @POST(GET_LOCATION)
    suspend fun initGetLocation(
        @Header(AUTHORIZATION) authHeader: String,
        @Query(EMAIL) email: String,
        @Query(USER_ID) userId: Int,
        @Query(DATE) date: String,
    ): ResponseGetLocationModel

    @GET(LOG_USER)
    suspend fun initLogUser(
        @Query(USER_ID) userId: Int,
        @Query(DATE_START) startDate: String,
        @Query(DATE_END) endDate: String,
    ): String

    @POST(SEND_TOKEN_FIREBASE)
    suspend fun initSendTokenFirebase(
        @Query(USER_ID) userId: Int,
        @Query(TOKEN_FIREBASE) tokenFirebase: String
    ): ResponseMessageModel


}