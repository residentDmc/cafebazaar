package com.dev.alarmapplication.data.api.open_street_map

interface ApiMapIrHelper {
    suspend fun initRevers(
        lat: String,
        lon: String
    ): Any
}
