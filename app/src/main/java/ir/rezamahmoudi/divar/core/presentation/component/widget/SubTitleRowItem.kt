package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowUiModel

@Composable
fun SubTitleRowItem(
    modifier: Modifier = Modifier,
    subTitle: WidgetSubTitleRowUiModel
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = subTitle.data.text,
        style = AppTheme.typography.text14Medium,
        color = AppTheme.colors.designSystem.primaryText
    )
}
