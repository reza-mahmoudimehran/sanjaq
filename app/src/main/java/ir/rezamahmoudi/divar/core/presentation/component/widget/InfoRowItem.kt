package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetInfoRowDataUiModel

@Composable
fun InfoRowItem(
    modifier: Modifier = Modifier,
    info: WidgetInfoRowDataUiModel
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = AppTheme.dimensions.mainContentPadding)
        ) {
            Text(
                modifier = Modifier
                    .weight(1F),
                text = info.title,
                style = AppTheme.typography.text12Medium,
                color = AppTheme.colors.designSystem.primaryText
            )
            Text(
                text = info.value,
                style = AppTheme.typography.text12Bold,
                color = AppTheme.colors.designSystem.primaryText
            )
        }
        Divider(color = AppTheme.colors.designSystem.primaryDivider)
    }
}
