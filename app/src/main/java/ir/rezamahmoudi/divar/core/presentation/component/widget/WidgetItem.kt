package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.runtime.Composable
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDescriptionRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetHeaderRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetImageSliderRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetInfoRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowDataUiModel

@Composable
fun WidgetItem(
    widget: WidgetDataUiModel,
    onNavigateToScreen: (String) -> Unit
) {
    when (widget) {
        is WidgetTitleRowDataUiModel -> {
            TitleRowItem(title = widget)
        }
        is WidgetSubTitleRowDataUiModel -> {
            SubTitleRowItem(subTitle = widget)
        }
        is WidgetPostRowDataUiModel -> {
            PostRowItem(
                post = widget,
                onNavigateToScreen = onNavigateToScreen
            )
        }
        is WidgetHeaderRowDataUiModel -> {
            HeaderRowItem(header = widget)
        }
        is WidgetInfoRowDataUiModel -> {
            InfoRowItem(info = widget)
        }
        is WidgetDescriptionRowDataUiModel -> {
            DescriptionRowItem(description = widget)
        }
        is WidgetImageSliderRowDataUiModel -> {
            ImageSliderRowItem(imageSlider = widget)
        }
    }
}
