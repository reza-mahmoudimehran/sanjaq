package ir.rezamahmoudi.divar.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.R
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.core.presentation.widget.animation.MotionPlayer
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = AppTheme.colors.designSystem.primaryBackground)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.logo_transparent),
            contentDescription = "Logo"
        )

        MotionPlayer(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .height(64.dp),
            isPlaying = true,
            speed = 1f,
            restartOnPlay = true,
            resId = R.raw.loading
        )
    }

    LaunchedEffect(key1 = Unit) {
        delay(3_00)
        popBackStack()
        onNavigateToScreen(Screen.CitySelection.route)
    }
}
