package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowDataUiModel

@Composable
fun SubTitleRowItem(
    modifier: Modifier = Modifier,
    subTitle: WidgetSubTitleRowDataUiModel
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AppTheme.colors.designSystem.primaryBackground)
            .padding(vertical = 4.dp, horizontal = AppTheme.dimensions.mainContentPadding),
        text = subTitle.text,
        style = AppTheme.typography.text14Medium,
        color = AppTheme.colors.designSystem.primaryText
    )
}
