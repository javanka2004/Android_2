package com.example.androidlab.ui.Package

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

val Purple80 = Color(0xBBD9BBBB)
val PurpleGrey80 = Color(0xBBCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xBB6650a4)
val PurpleGrey40 = Color(0xbF625b41)
val Pink40 = Color(0xFF7D5690)

val colorBackground = "#050B18"
val colorChip = "#1c4c66"
val colorChipText = "#44a9e0"
val colorDarkGray = "#45454D"
val colorStartVideo = "#3dFFFFFF"

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
object MyTextStyle {
    val ChipStyle = TextStyle(
        color = Color(android.graphics.Color.parseColor(colorChipText)),
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        letterSpacing = 0.5.sp
    )
    val CommentNameStyle = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp
    )
    val CommentDateStyle = TextStyle(
        color = Color(android.graphics.Color.parseColor(colorDarkGray)),
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp
    )
    val CommentTextStyle = TextStyle(
        color = Color.Gray,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp,
    )
    val HeaderTextStyle = TextStyle(
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )
    val HeaderCounterStyle = TextStyle(
        color = Color(android.graphics.Color.parseColor(colorDarkGray)),
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )
    val DescriptionStyle = TextStyle(
        color = Color.Gray,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 19.sp,
        letterSpacing = 0.5.sp
    )
    val RewiewAndRatingsTextStyle = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 19.sp,
        letterSpacing = 0.6.sp
    )
    val RatingRatingStyle = TextStyle(
        color = Color.White,
        fontSize = 48.sp,
        fontWeight = FontWeight.W700,
        letterSpacing = 0.5.sp
    )
    val RatingCounterStyle = TextStyle(
        color = Color.Gray,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )
    val ButtonStyle = TextStyle(
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        letterSpacing = 0.6.sp
    )
}

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

)

@Composable
fun AndroidLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}