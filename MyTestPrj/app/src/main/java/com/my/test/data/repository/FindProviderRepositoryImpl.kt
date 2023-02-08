package com.my.test.data.repository

import com.my.test.data.remote.FindProvidersApi
import com.my.test.data.remote.dto.ProviderDTO
import com.my.test.domain.repository.FindProviderRepository
import javax.inject.Inject

class FindProviderRepositoryImpl @Inject constructor(private val api: FindProvidersApi) : FindProviderRepository {

    override suspend fun getProviders(): ProviderDTO {
        return api.getProviders()
    }
}