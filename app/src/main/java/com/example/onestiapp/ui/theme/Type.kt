package com.example.onestiapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.onestiapp.R

val open_sans = FontFamily(
    listOf(
        Font(R.font.open_sans_light, FontWeight.Light),
        Font(R.font.open_sans_regular, FontWeight.Normal),
        Font(R.font.open_sans_semi_bold, FontWeight.SemiBold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    subtitle1 = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    caption = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = open_sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
    )
)