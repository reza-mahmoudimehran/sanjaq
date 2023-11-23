package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.runtime.Composable
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel

@Composable
fun WidgetItem(
    widget: WidgetUiModel,
    onNavigateToScreen: (String) -> Unit
) {
    when (widget) {
        is WidgetSubTitleRowUiModel -> {
            SubTitleRowItem(subTitle = widget)
        }
        is WidgetTitleRowUiModel -> {
            TitleRowItem(title = widget)
        }
        is WidgetPostRowUiModel -> {
            PostRowItem(
                post = widget,
                onNavigateToScreen = onNavigateToScreen
            )
        }
    }
}
