package com.my.test.ui.presentation.providers

import com.my.test.domain.model.Provider

data class FindProviderState(
    val isLoading:Boolean = false,
    val providers: List<Provider> = emptyList(),
    val error: String = ""
)
