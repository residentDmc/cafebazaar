package com.dev.alarmapplication.data.api.register_phone

class ApiHelperRegisterPhoneImpl(private val apiServiceRegisterPhone: ApiServiceRegisterPhone) : ApiHelperRegisterPhone {
    override suspend fun initRegister(
        tell: String
    ): Any =
        try {
            apiServiceRegisterPhone.initRegister(tell)
        } catch (e: Exception) {
            e
        }

    override suspend fun initActivationCode(tell: String, code: String, deviceName: String): Any =
        try {
            apiServiceRegisterPhone.initActivationCode(tell,code,deviceName)
        } catch (e: Exception) {
            e
        }

    override suspend fun initLogin(username: String, password: String, deviceName: String): Any =
        try {
            apiServiceRegisterPhone.initLogin(username, password, deviceName)
        } catch (e: Exception) {
            e
        }

    override suspend fun initListOfRepresentativeCitiesModel():  Any =
        try {
            apiServiceRegisterPhone.initListOfRepresentativeCitiesModel()
        } catch (e: Exception) {
            e
        }

    override suspend fun initSendAddressModel(
        ids: String,
        tell: String,
        userTell: String,
        city: String
    ): Any =
        try {
            apiServiceRegisterPhone.initSendAddressModel(ids,tell,userTell,city)
        } catch (e: Exception) {
            e
        }
}