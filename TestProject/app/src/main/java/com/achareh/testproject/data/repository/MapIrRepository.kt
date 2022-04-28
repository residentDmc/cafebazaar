package com.achareh.testproject.data.repository

import com.achareh.testproject.data.api.open_street_map.ApiMapIrHelper

class MapIrRepository(private val apiMapIrHelper: ApiMapIrHelper) {

    suspend fun initRevers(
        lat: String,
        lon: String
    ) = apiMapIrHelper.initRevers(lat, lon)


}