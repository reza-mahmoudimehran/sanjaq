package ir.rezamahmoudi.divar.core.presentation.widget.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomPager(
    modifier: Modifier = Modifier,
    pageSize: PageSize = PageSize.Fill,
    userScrollEnabled: Boolean = true,
    reverseLayout: Boolean = false,
    state: PagerState,
    pageSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(),
    key: ((Int) -> String)? = null,
    content: @Composable (Int, Int) -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HorizontalPager(
            modifier = modifier,
            state = state,
            pageSpacing = pageSpacing,
            userScrollEnabled = userScrollEnabled,
            reverseLayout = reverseLayout,
            contentPadding = contentPadding,
            beyondBoundsPageCount = 0,
            pageSize = pageSize,
            flingBehavior = PagerDefaults.flingBehavior(state = state),
            key = key,
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                Orientation.Horizontal
            ),
            pageContent = {
                content(it, state.currentPage)
            }
        )
    }
}
