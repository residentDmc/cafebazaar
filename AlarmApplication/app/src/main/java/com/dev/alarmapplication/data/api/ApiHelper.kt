package com.dev.alarmapplication.data.api

import com.dev.alarmapplication.data.model.request.add_ad_divar_orinab.RequestAddAdDrivarOrinab
import com.dev.alarmapplication.utils.build_config.BuildConfig
import okhttp3.MultipartBody
import retrofit2.http.Query


interface ApiHelper {

    suspend fun initMobileViewSheypoor(): Any
    suspend fun initGetNumberSheypoor(ids:String): Any
    suspend fun intLogin(email:String,password:String): Any
    suspend fun initAdvSub(requestAddAdDrivarOrinab: RequestAddAdDrivarOrinab): Any
    suspend fun initUploadImageDivarOrinab(image: MultipartBody.Part): Any
    suspend fun initDeleteImageDivarOrinab(image: String): Any
    suspend fun intAddArrivals(date:String, address:String, location:String,state:Int, userId:Int, desc:String): Any
    suspend fun intAddMission(date:String, address:String, state:Int, userId:Int, desc:String): Any
    suspend fun intAddLeve(startDate:String, endDate:String,state:Int, userId:Int, desc:String): Any
    suspend fun intEditRequestSingleLeave(type:String, email:String,id:Int,startDate:String, endDate:String, state:Int, userId:Int, desc:String): Any
    suspend fun initDeleteRequestSingleLeave(type:String, email:String,id:Int, userId:Int): Any
    suspend fun intEditRequestSingleMission(type:String, email:String,id:Int,date:String, state:Int, userId:Int, desc:String): Any
    suspend fun intEditRequestSingle(type:String, email:String,id:Int,isValid:Int, userId:Int, descManage:String): Any
    suspend fun intViewMileSingle(type:String, id:Int): Any
    suspend fun intViewMileSingleUser( id:Int): Any
    suspend fun intViewMile(email:String): Any
    suspend fun intViewArrivalsUser(startDate:String, endDate:String, userId:Int): Any
    suspend fun intViewAllUser( email:String): Any
    suspend fun initViewMiLeFalse( email:String): Any
    suspend fun initViewMiLeTrue( email:String): Any
    suspend fun initSaveLocation(userId:Int,date:String, location:String): Any
    suspend fun initGetLocation(email:String,userId:Int,date: String): Any
    suspend fun initLogUser(userId:Int, startDate: String, endDate: String): Any
    suspend fun initSendTokenFirebase(userId:Int, tokenFirebase: String): Any
}