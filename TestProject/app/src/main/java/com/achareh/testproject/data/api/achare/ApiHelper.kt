package com.achareh.testproject.data.api.achare

import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel

interface ApiHelper {

    suspend fun initAddressList(): Any
    suspend fun initSaveAddress(requestSaveAddressModel: RequestSaveAddressModel): Any
}