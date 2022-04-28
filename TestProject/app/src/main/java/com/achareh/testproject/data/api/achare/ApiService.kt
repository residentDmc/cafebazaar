package com.achareh.testproject.data.api.achare

import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel
import com.achareh.testproject.data.model.response.address_list.AddressItem
import com.achareh.testproject.data.model.response.address_list.ResponseAddressListModel
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.ADDRESS
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.CONTENT_TYPE
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.CONTENT_TYPE_VALUE
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {

    @GET(ADDRESS)
    suspend fun initAddressList(): ResponseAddressListModel

    @POST(ADDRESS)
    suspend fun initSaveAddress(
        @Header(CONTENT_TYPE) contentType: String?=CONTENT_TYPE_VALUE,
        @Body requestSaveAddressModel: RequestSaveAddressModel,
    ): AddressItem

}