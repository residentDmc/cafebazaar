package com.dev.alarmapplication.data.api.register_phone


interface ApiHelperRegisterPhone {


    suspend fun initRegister(tell: String): Any
    suspend fun initActivationCode(tell: String,code: String, deviceName: String): Any
    suspend fun initLogin(username: String, password: String,deviceName: String): Any
    suspend fun initListOfRepresentativeCitiesModel(): Any
    suspend fun initSendAddressModel(ids:String,tell:String, userTell:String, city:String): Any


}