package com.my.test.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.my.test.R

val SourceSansPro = FontFamily(
    Font(R.font.source_sans_pro_regular, FontWeight.Normal),
    Font(R.font.source_sans_pro_semibold, FontWeight.SemiBold),
    Font(R.font.source_sans_pro_bold, FontWeight.Bold)
)

private val defaultTypography = Typography()

val Typography = Typography(
    body1 = defaultTypography.body1.copy(
        fontFamily = SourceSansPro,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Grey
    ),
    h5 = defaultTypography.h5.copy(
        fontFamily = SourceSansPro,
        fontWeight = FontWeight.Normal,
        color = Grey
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)