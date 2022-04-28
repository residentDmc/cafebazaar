package com.achareh.testproject.data.api.open_street_map

import com.achareh.testproject.data.model.response.address_map_ir.ResponseAddressMapIrModel
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.LAT
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.LON
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.REVERS
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.TOKEN_MAP
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.X_API_KEY
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiMapIrService {

    @GET(REVERS)
    suspend fun initRevers(
        @Header(X_API_KEY) xApiKey: String?=TOKEN_MAP,
        @Query(LAT) lat: String,
        @Query(LON) lon: String
    ): ResponseAddressMapIrModel



}