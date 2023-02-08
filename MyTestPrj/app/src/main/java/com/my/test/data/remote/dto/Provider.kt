package com.my.test.data.remote.dto

import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

data class Provider(
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("distance")
    val distance: Double?,
    @SerializedName("geocode")
    val geocode: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("postalcode")
    val postalcode: String?,
    @SerializedName("province")
    val province: String?,
    @SerializedName("role")
    val role: String?
)

fun Provider.toProvider(): com.my.test.domain.model.Provider {
    return com.my.test.domain.model.Provider(
        name = name,
        distance = calculateDistance(distance),
        address = address,
        city = city,
        province = province,
        postalCode = postalcode,
        phone = phone
    )
}

private fun calculateDistance(distance: Double?): Double {
    distance?.let {
        return (distance.toDouble() / 10).roundToInt() / 100.0
    }
    return 0.0;
}
