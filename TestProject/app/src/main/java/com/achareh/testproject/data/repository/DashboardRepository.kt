package com.achareh.testproject.data.repository

import com.achareh.testproject.data.api.achare.ApiHelper
import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel

class DashboardRepository(private val apiHelper: ApiHelper) {

    suspend fun initAddressList() = apiHelper.initAddressList()
    suspend fun initSaveAddress(requestSaveAddressModel: RequestSaveAddressModel) = apiHelper.initSaveAddress(requestSaveAddressModel)

}