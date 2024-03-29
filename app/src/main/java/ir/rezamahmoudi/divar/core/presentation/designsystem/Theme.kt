package ir.rezamahmoudi.divar.core.presentation.designsystem

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat

@Composable
fun DivarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorPalette.materialColorScheme
        else -> lightColorPalette.materialColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val colors = remember {
        if (darkTheme) {
            darkColorPalette
        } else {
            lightColorPalette
        }
    }

    CompositionLocalProvider(
        localColors provides colors,
        localTypography provides AppTheme.typography,
        localDimensions provides AppTheme.dimensions
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = appTypography.materialTypography,
            content = content
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = localColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = localDimensions.current
}

private val lightColorPalette = AppColors(
    materialColorScheme = lightColorScheme(
        // You can override default colors
    ),
    designSystem = DesignSystem()
)

private val darkColorPalette = AppColors(
    materialColorScheme = darkColorScheme(),
    designSystem = DesignSystem(
        primaryBackground = Gray90,
        primaryCardBackground = Gray80,
        primaryText = Gray20,
        secondaryText = Lemon,
        primaryIconTint = Gray50,
        primaryDivider = Gray20
    )
)

private val appTypography = AppTypography(
    materialTypography = Typography
)

private val appDimensions = AppDimensions()

private val localColors = staticCompositionLocalOf { lightColorPalette }
private val localTypography = staticCompositionLocalOf { appTypography }
private val localDimensions = staticCompositionLocalOf { appDimensions }

/**
 * Multipreview annotation that represents light and dark themes. Add this annotation to a
 * composable to render the both themes.
 */
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews
