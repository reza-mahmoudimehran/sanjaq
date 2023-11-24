package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDescriptionRowDataUiModel

@Composable
fun DescriptionRowItem(
    modifier: Modifier = Modifier,
    description: WidgetDescriptionRowDataUiModel
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = AppTheme.dimensions.mainContentPadding),
        text = description.text,
        style = AppTheme.typography.text12Medium,
        color = AppTheme.colors.designSystem.primaryText
    )
}
