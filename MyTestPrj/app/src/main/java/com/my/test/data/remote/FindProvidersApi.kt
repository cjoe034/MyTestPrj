package com.my.test.data.remote

import com.my.test.data.remote.dto.ProviderDTO
import retrofit2.http.GET

interface FindProvidersApi {

    @GET("services/findaprovider/search.json?s=0&c=40&d=5&lat=43.6368447&lng=-79.40046380000001&r=Acupuncturist")
    suspend fun getProviders(): ProviderDTO
}