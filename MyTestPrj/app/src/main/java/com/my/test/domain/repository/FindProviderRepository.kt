package com.my.test.domain.repository

import com.my.test.data.remote.dto.ProviderDTO

interface FindProviderRepository {

    suspend fun getProviders() :ProviderDTO
}