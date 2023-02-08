package com.my.test.ui.presentation

sealed class Screen(val route: String) {
    object FindProviderScreen: Screen("provider_screen")
}