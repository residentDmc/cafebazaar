package com.dev.alarmapplication.data.model.local.location


data class EmitLocation(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val rotate: Float,
    val off: Boolean,
    val date: String,
)