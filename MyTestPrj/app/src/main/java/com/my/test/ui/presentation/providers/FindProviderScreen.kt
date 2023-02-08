package com.my.test.ui.presentation.providers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.my.test.domain.model.Provider
import com.my.test.ui.theme.MyTheme
import com.my.test.ui.theme.Typography

@Composable
fun FindProviderScreen(
    viewModel: FindProviderViewModel = hiltViewModel()
) {
    val currentState: State<FindProviderState> = viewModel.state

    FindAProviderContent(currentState.value.providers)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFf0f0ef,
    device = Devices.PIXEL_4
)
@Composable
fun FindAProviderContent(
    @PreviewParameter(FindProviderPreviewParameter::class) providers: List<Provider>
) {
    MyTheme() {
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 16.dp)
                .fillMaxSize()
        ) {
            // Search bar with address
            item {
                FindProviderSearchBar(address = "600 Fleet St, Toronto, ON M5V 1B7, Canada")
            }

            // List of Providers
            if (providers.isNotEmpty()) {
                item {
                    FindProviderNearYou(providerType = "Acupuncturist")
                }

                items(providers) { provider ->
                    Row() {
                        ProviderCard(provider)
                    }
                }
            }
        }
    }
}

@Composable
fun FindProviderSearchBar(address: String?) {
    Spacer(modifier = Modifier.height(16.dp))
    // Address Label
    Text(text = "Address")

    // Editable Text Field
    TextField(
        singleLine = true,
        value = address ?: "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun FindProviderNearYou(providerType: String) {
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = providerType + "s near you", style = Typography.h5)
    Spacer(modifier = Modifier.height(16.dp))
}
