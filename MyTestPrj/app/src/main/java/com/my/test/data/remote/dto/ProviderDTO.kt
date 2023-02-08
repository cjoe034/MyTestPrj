package com.my.test.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProviderDTO(
    @SerializedName("distance") val distance: Double?,
    @SerializedName("lat") val lat: Double?,
    @SerializedName("limit") val limit: Int?,
    @SerializedName("lng") val lng: Double?,
    @SerializedName("providers") val providers: List<Provider>?,
    @SerializedName("results") val results: Int?,
    @SerializedName("role") val role: String?,
    @SerializedName("size") val size: Int?,
    @SerializedName("start") val start: Int?,
    @SerializedName("total") val total: Int?
)
