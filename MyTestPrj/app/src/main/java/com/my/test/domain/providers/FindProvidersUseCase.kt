package com.my.test.domain.providers

import com.my.test.common.ApiStatus
import com.my.test.data.remote.dto.toProvider
import com.my.test.domain.model.Provider
import com.my.test.domain.repository.FindProviderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FindProvidersUseCase @Inject constructor(
    private val repository: FindProviderRepository
) {
    operator fun invoke(): Flow<ApiStatus<List<Provider>>> = flow {
        try {
            emit(ApiStatus.Loading())
            val providerDTO = repository.getProviders()
            val provider = providerDTO.providers?.map { it.toProvider() } ?: emptyList()
            emit(ApiStatus.Success(provider))
        } catch (e: HttpException) {
            emit(ApiStatus.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(ApiStatus.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: Exception) {
            emit(ApiStatus.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}