package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetImageSliderRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.widget.image.NetworkImage
import ir.rezamahmoudi.divar.core.presentation.widget.pager.CustomPager
import ir.rezamahmoudi.divar.core.util.test.TestTagConstants.IMAGE_SLIDER_ROW_ITEM_TEST_TAG

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSliderRowItem(
    modifier: Modifier = Modifier,
    imageSlider: WidgetImageSliderRowDataUiModel
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { imageSlider.items.size }

    CustomPager(
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp)
            .background(color = AppTheme.colors.designSystem.primaryBackground)
            .testTag(IMAGE_SLIDER_ROW_ITEM_TEST_TAG),
        state = pagerState
    ) { index, _ ->
        imageSlider.items.getOrNull(index)?.let { image ->
            NetworkImage(
                imageModifier = Modifier.fillMaxSize(),
                url = image.imageUrl
            )
        }
    }
}
