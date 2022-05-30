package com.dev.alarmapplication.data.api.open_street_map

import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.TOKEN_MAP

class ApiMapIrHelperImpl(private val apiMapIrService: ApiMapIrService) : ApiMapIrHelper {

    override suspend fun initRevers(lat: String, lon: String): Any =
        try {
            apiMapIrService.initRevers(TOKEN_MAP,lat, lon)
        } catch (e: Exception) {
            e
        }


}