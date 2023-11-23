package ir.rezamahmoudi.divar.core.util.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import ir.rezamahmoudi.divar.core.presentation.designsystem.DivarTheme

@Composable
fun PreviewWrapper(content: @Composable () -> Unit) {
    DivarTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            content()
        }
    }
}
