package com.dev.alarmapplication.data.model.response.list_of_representative_cities

data class ItemOfCitiesModel(
    val address: String,
    val city: String,
    val created_at: String,
    val deleted_at: String,
    val id: Int,
    val tell: String,
    val updated_at: String
)