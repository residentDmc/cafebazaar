package com.dev.alarmapplication.data.api.register_phone

import com.dev.alarmapplication.data.model.response.city_address.ResponseCityAddressModel
import com.dev.alarmapplication.data.model.response.login_register_phone.ResponseLoginRegisterPhoneModel
import com.dev.alarmapplication.data.model.response.register.ResponseRegisterModel
import com.dev.alarmapplication.data.model.response.send_address.ResponseSendAddressModel
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone
import com.dev.alarmapplication.utils.build_config.BuildConfig
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.ACTIVATION_CODE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.CITY
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.CODE
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.DEVICE_NAME
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.IDS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LOGIN
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.PASSWORD
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REGISTER
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.SEND_ADDRESS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.TELL
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.USER_NAME
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.USER_TELL
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiServiceRegisterPhone {

    @GET(REGISTER)
    suspend fun initRegister(@Query(TELL) tell: String): ResponseRegisterModel

    @GET(ACTIVATION_CODE)
    suspend fun initActivationCode(
        @Query(TELL) tell: String,
        @Query(CODE) code: String,
        @Query(DEVICE_NAME) deviceName: String
    ): VerificationRegisterPhone

    @POST(LOGIN)
    suspend fun initLogin(
        @Query(USER_NAME) username: String,
        @Query(PASSWORD) password: String,
        @Query(DEVICE_NAME) deviceName: String
    ): ResponseLoginRegisterPhoneModel

    @GET(BuildConfig.VIEW_ADDRESS)
    suspend fun initListOfRepresentativeCitiesModel(): ResponseCityAddressModel

    @POST(SEND_ADDRESS)
    suspend fun initSendAddressModel(
        @Query(IDS) ids: String,
        @Query(TELL) tell: String,
        @Query(USER_TELL) userTell: String,
        @Query(CITY) city: String
    ): ResponseSendAddressModel


}