package com.my.test.ui.presentation.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.my.test.domain.model.Provider

class FindProviderPreviewParameter : PreviewParameterProvider<List<Provider>> {
    override val values = sequenceOf(
        listOf(
            Provider(
                name = "PAULA MORGADO",
                address = "175 FORT YORK Boulevard",
                city = "Toronto",
                province = "ON",
                postalCode = "M5V 0C7",
                distance = 174.93892678579488,
                phone = "647 456 9200"
            ),
            Provider(
                name = "HUALI WANG",
                address = "151 DAN LECKIE WAY",
                city = "TORONTO",
                province = "ON",
                postalCode = "M5V 4B2",
                distance = 384.39137864749716,
                phone = "416 551 2306"
            ),
            Provider(
                name = "NING SHI",
                address = "12 TELEGRAM MEWS",
                city = "Toronto",
                province = "ON",
                postalCode = "M5V 3Z4",
                distance = 620.1962585668658,
                phone = "647 343 8123"
            ),
            Provider(
                name = "PAULA MORGADO",
                address = "175 FORT YORK Boulevard",
                city = "Toronto",
                province = "ON",
                postalCode = "M5V 0C7",
                distance = 174.93892678579488,
                phone = "647 456 9200"
            ),
            Provider(
                name = "HUALI WANG",
                address = "151 DAN LECKIE WAY",
                city = "TORONTO",
                province = "ON",
                postalCode = "M5V 4B2",
                distance = 384.39137864749716,
                phone = "416 551 2306"
            ),
            Provider(
                name = "NING SHI",
                address = "12 TELEGRAM MEWS",
                city = "Toronto",
                province = "ON",
                postalCode = "M5V 3Z4",
                distance = 620.1962585668658,
                phone = "647 343 8123"
            )
        )
    ).asSequence()
}
