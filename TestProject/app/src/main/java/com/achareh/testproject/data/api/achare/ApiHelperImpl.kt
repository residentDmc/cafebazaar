package com.achareh.testproject.data.api.achare

import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun initAddressList(): Any =
        try {
            apiService.initAddressList()
        } catch (e: Exception) {
            e
        }

    override suspend fun initSaveAddress(requestSaveAddressModel: RequestSaveAddressModel): Any =
        try {
            apiService.initSaveAddress(requestSaveAddressModel = requestSaveAddressModel)
        } catch (e: Exception) {
            e
        }


}