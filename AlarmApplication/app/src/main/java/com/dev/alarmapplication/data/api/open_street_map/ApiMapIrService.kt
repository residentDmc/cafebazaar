package com.dev.alarmapplication.data.api.open_street_map

import com.dev.alarmapplication.data.model.response.address_map_ir.ResponseAddressMapIrModel
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LAT
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.LON
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.REVERS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.X_API_KEY
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiMapIrService {

    @GET(REVERS)
    suspend fun initRevers(
        @Header(X_API_KEY) xApiKey: String,
        @Query(LAT) lat: String,
        @Query(LON) lon: String
    ): ResponseAddressMapIrModel



}