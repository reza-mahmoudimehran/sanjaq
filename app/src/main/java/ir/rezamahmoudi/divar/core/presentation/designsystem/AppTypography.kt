package ir.rezamahmoudi.divar.core.presentation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.rezamahmoudi.divar.R

private val mainFont = FontFamily(Font(R.font.font_vazir))
data class AppTypography(
    val materialTypography: Typography,

    val text: TextStyle = TextStyle(
        fontFamily = mainFont
    ),

    val text8: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 8.sp
    ),
    val text10: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 10.sp
    ),
    val text10Bold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    ),
    val text12: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 12.sp
    ),
    val text12Bold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    ),
    val text12Medium: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    val text14: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 14.sp
    ),
    val text14Bold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    ),
    val text14Medium: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    val text16Medium: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val text16Bold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val text16ExtraBold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    val text18Bold: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    val text18Medium: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    val text18: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 18.sp
    ),
    val text20Medium: TextStyle = TextStyle(
        fontFamily = mainFont,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    )
)
