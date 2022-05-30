package com.dev.alarmapplication.data.model.response.arrivals_and_departures.list


import com.google.gson.annotations.SerializedName

data class ResponseArrivalsAndDeparturesListModel(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("data")
    val arrivalsAndDepartures: List<ArrivalsAndDepartures>,
    @SerializedName("first_page_url")
    val firstPageUrl: String,
    @SerializedName("from")
    val from: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("last_page_url")
    val lastPageUrl: String,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("next_page_url")
    val nextPageUrl: Any,
    @SerializedName("path")
    val path: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("prev_page_url")
    val prevPageUrl: Any,
    @SerializedName("to")
    val to: Int,
    @SerializedName("total")
    val total: Int
)