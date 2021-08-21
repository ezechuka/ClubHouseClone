package com.javalon.clubhouseclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.javalon.clubhouseclone.R

private val SofiaPro = FontFamily(
    Font(R.font.sofia_pro_light),
    Font(R.font.sofia_pro_medium, weight = FontWeight.W500),
    Font(R.font.sofia_pro_semi_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),

    h3 = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.W300,
        fontSize = 22.sp
    ),

    caption = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.W300,
        fontSize = 16.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.W300,
        fontSize = 15.sp
    ),

    body1 = TextStyle(
        fontFamily = SofiaPro,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

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