package com.dev.alarmapplication.data.api

import com.dev.alarmapplication.data.model.request.add_ad_divar_orinab.RequestAddAdDrivarOrinab
import com.dev.alarmapplication.utils.application.AppOfficialOrinab.Companion.initUser
import okhttp3.MultipartBody

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun initMobileViewSheypoor(): Any =
        try {
            apiService.initMobileViewSheypoor()
        } catch (e: Exception) {
            e
        }

    override suspend fun initGetNumberSheypoor(ids:String): Any =
        try {
            apiService.initGetNumberSheypoor(ids)
        } catch (e: Exception) {
            e
        }

    override suspend fun intLogin(email: String, password: String): Any =
        try {
            apiService.intLogin(email, password)
        } catch (e: Exception) {
            e
        }

    override suspend fun initAdvSub(requestAddAdDrivarOrinab: RequestAddAdDrivarOrinab): Any =
        try {
            apiService.initAdvSub(requestAddAdDrivarOrinab)
        } catch (e: Exception) {
            e
        }

    override suspend fun initUploadImageDivarOrinab(image: MultipartBody.Part): Any =
        try {
            apiService.initUploadImageDivarOrinab(image)
        } catch (e: Exception) {
            e
        }

    override suspend fun initDeleteImageDivarOrinab(image: String): Any =
        try {
            apiService.initDeleteImageDivarOrinab(image)
        } catch (e: Exception) {
            e
        }

    override suspend fun intAddArrivals(
        date: String,
        address: String,
        location: String,
        state: Int,
        userId: Int,
        desc: String
    ): Any =
        try {
            apiService.intAddArrivals(date, address, location, state, userId, desc)
        } catch (e: Exception) {
            e
        }

    override suspend fun intAddMission(
        date: String,
        address: String,
        state: Int,
        userId: Int,
        desc: String
    ): Any =
        try {
            apiService.intAddMission(date, address, state, userId, desc)
        } catch (e: Exception) {
            e
        }

    override suspend fun intAddLeve(
        startDate: String,
        endDate: String,
        state: Int,
        userId: Int,
        desc: String
    ):  Any =
        try {
            apiService.intAddLeve(startDate, endDate, state, userId, desc)
        } catch (e: Exception) {
            e
        }

    override suspend fun intEditRequestSingleLeave(
        type:String, email:String,
        id: Int,
        startDate: String,
        endDate: String,
        state: Int,
        userId: Int,
        desc: String
    ): Any =
        try {
            apiService.intEditRequestSingleLeave(initUser()!!.initBearerToken(),type,email,id,startDate, endDate, state, userId, desc)
        } catch (e: Exception) {
            e
        }

    override suspend fun initDeleteRequestSingleLeave(
        type: String,
        email: String,
        id: Int,
        userId: Int
    ): Any =
        try {
            apiService.initDeleteRequestSingleLeave(initUser()!!.initBearerToken(),type,email,id, userId)
        } catch (e: Exception) {
            e
        }

    override suspend fun intEditRequestSingleMission(
        type: String,
        email: String,
        id: Int,
        date: String,
        state: Int,
        userId: Int,
        desc: String
    ): Any =
        try {
            apiService.intEditRequestSingleMission(initUser()!!.initBearerToken(),type,email,id,date, state, userId, desc)
        } catch (e: Exception) {
            e
        }

    override suspend fun intEditRequestSingle(
        type: String,
        email: String,
        id: Int,
        isValid:Int,
        userId: Int,
        descManage: String
    ): Any =
        try {
            apiService.intEditRequestSingle(initUser()!!.initBearerToken(),type,email,id,isValid, userId, descManage)
        } catch (e: Exception) {
            e
        }

    override suspend fun intViewMileSingle(type: String, id: Int): Any =
        try {
            apiService.intViewMileSingle(type, id)
        } catch (e: Exception) {
            e
        }

    override suspend fun intViewMileSingleUser(id: Int): Any =
        try {
            apiService.intViewMileSingleUser(id)
        } catch (e: Exception) {
            e
        }

    override suspend fun intViewMile(email: String): Any =
        try {
            apiService.intViewMile(initUser()!!.initBearerToken(),email)
        } catch (e: Exception) {
            e
        }

    override suspend fun intViewArrivalsUser(startDate: String, endDate: String, userId: Int): Any =
        try {
            apiService.intViewArrivalsUser(startDate, endDate, userId)
        } catch (e: Exception) {
            e
        }

    override suspend fun intViewAllUser(email: String):Any =
        try {
            apiService.intViewAllUser(initUser()!!.initBearerToken(),email)
        } catch (e: Exception) {
            e
        }

    override suspend fun initViewMiLeFalse(email: String): Any =
        try {
            apiService.initViewMiLeFalse(initUser()!!.initBearerToken(),email)
        } catch (e: Exception) {
            e
        }

    override suspend fun initViewMiLeTrue(email: String):  Any =
        try {
            apiService.initViewMiLeTrue(initUser()!!.initBearerToken(),email)
        } catch (e: Exception) {
            e
        }

    override suspend fun initSaveLocation(userId: Int,date:String, location: String): Any =
        try {
            apiService.initSaveLocation(initUser()!!.initBearerToken(),userId,date,location)
        } catch (e: Exception) {
            e
        }

    override suspend fun initGetLocation(email: String, userId: Int,date: String): Any =
        try {
            apiService.initGetLocation(initUser()!!.initBearerToken(),email,userId,date)
        } catch (e: Exception) {
            e
        }

    override suspend fun initLogUser(userId: Int, startDate: String, endDate: String): Any =
        try {
            apiService.initLogUser(userId,startDate, endDate)
        } catch (e: Exception) {
            e
        }

    override suspend fun initSendTokenFirebase(userId: Int, tokenFirebase: String):  Any =
        try {
            apiService.initSendTokenFirebase(userId,tokenFirebase)
        } catch (e: Exception) {
            e
        }


}