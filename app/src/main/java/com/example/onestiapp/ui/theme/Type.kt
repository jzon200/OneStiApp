package com.example.onestiapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.onestiapp.R

val OpenSans = FontFamily(
    listOf(
        Font(R.font.open_sans_light, FontWeight.Light),
        Font(R.font.open_sans_regular, FontWeight.Normal),
        Font(R.font.open_sans_medium, FontWeight.Medium),
        Font(R.font.open_sans_semi_bold, FontWeight.SemiBold),
    )
)

val Roboto = FontFamily(
    listOf(
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_medium, FontWeight.Medium)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h6 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    overline = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    )
)