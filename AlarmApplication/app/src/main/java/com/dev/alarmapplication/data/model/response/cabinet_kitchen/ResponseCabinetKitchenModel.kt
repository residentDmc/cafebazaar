package com.dev.alarmapplication.data.model.response.cabinet_kitchen


import com.google.gson.annotations.SerializedName

data class ResponseCabinetKitchenModel(
    @SerializedName(value="PRO", alternate=["p"])
    val pro: List<Pro>,
    @SerializedName("TIT")
    val tit: TIT
)