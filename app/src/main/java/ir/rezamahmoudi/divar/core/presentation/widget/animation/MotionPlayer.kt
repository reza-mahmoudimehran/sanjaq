package ir.rezamahmoudi.divar.core.presentation.widget.animation

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MotionPlayer(
    @RawRes resId: Int,
    iterations: Int = 1,
    modifier: Modifier,
    isPlaying: Boolean,
    restartOnPlay: Boolean = false,
    speed: Float,
    contentScale: ContentScale = ContentScale.Fit,
    onMotionCompleted: (() -> Unit)? = null
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(resId)
    )

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = if (restartOnPlay) Int.MAX_VALUE else iterations,
        isPlaying = isPlaying,
        speed = speed
    )

    LaunchedEffect(key1 = progress, key2 = onMotionCompleted) {
        if (onMotionCompleted != null && progress == 1f) {
            onMotionCompleted()
        }
    }

    LottieAnimation(
        composition,
        progress,
        modifier = modifier,
        contentScale = contentScale
    )
}
