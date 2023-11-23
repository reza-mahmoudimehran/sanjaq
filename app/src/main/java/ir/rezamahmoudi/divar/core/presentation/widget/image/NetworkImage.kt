package ir.rezamahmoudi.divar.core.presentation.widget.image

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Scale
import ir.rezamahmoudi.divar.R

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    url: String,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null
) {
    val context = LocalContext.current

    val model = remember {
        ImageRequest.Builder(context)
            .data(url)
            .decoderFactory(SvgDecoder.Factory())
            .diskCacheKey(url)
            .memoryCacheKey(url)
            .scale(Scale.FILL)
            .placeholder(R.drawable.logo_transparent)
            .error(R.drawable.logo_transparent)
            .crossfade(true)
            .crossfade(100)
            .build()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = imageModifier,
            model = model,
            contentDescription = contentDescription,
            contentScale = contentScale,
            colorFilter = colorFilter
        )
    }
}
