package com.achareh.testproject.data.model.response.address_list


import com.google.gson.annotations.SerializedName

data class StateObject(
    @SerializedName("state_id")
    val stateId: Int,
    @SerializedName("state_name")
    val stateName: String
)