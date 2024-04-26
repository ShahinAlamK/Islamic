package com.example.islamic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.islamic.R


val banglaFont = FontFamily(
    Font(R.font.nato_regular),
    Font(R.font.nato_bold)
)
val arbicFont = FontFamily(
    Font(R.font.lateef)
)
val roboto = FontFamily(
    Font(R.font.roboto, weight = FontWeight.Normal)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = banglaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = arbicFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = banglaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),

    labelMedium = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

)