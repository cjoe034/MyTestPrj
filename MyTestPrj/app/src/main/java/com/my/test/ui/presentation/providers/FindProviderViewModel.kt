package com.my.test.ui.presentation.providers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.test.common.ApiStatus
import com.my.test.domain.providers.FindProvidersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FindProviderViewModel @Inject constructor(
    private val findProvidersUseCase: FindProvidersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FindProviderState())
    val state: State<FindProviderState> = _state

    init {
        getProviders()
    }

    private fun getProviders() {
        findProvidersUseCase().flowOn(Dispatchers.IO).onEach { result ->
            when (result) {
                is ApiStatus.Success -> {
                    _state.value = FindProviderState(providers = result.data ?: emptyList())
                }
                is ApiStatus.Error -> {
                    _state.value = FindProviderState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is ApiStatus.Loading -> {
                    _state.value = FindProviderState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
