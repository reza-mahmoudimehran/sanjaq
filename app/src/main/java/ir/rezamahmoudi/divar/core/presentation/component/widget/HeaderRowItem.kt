package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetHeaderRowDataUiModel

@Composable
fun HeaderRowItem(
    modifier: Modifier = Modifier,
    header: WidgetHeaderRowDataUiModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AppTheme.colors.designSystem.primaryBackground)
            .padding(vertical = 4.dp, horizontal = AppTheme.dimensions.mainContentPadding)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            text = header.title,
            style = AppTheme.typography.text14Bold,
            color = AppTheme.colors.designSystem.primaryText
        )
        header.subtitle?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                text = it,
                style = AppTheme.typography.text12Medium,
                color = AppTheme.colors.designSystem.primaryText
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}
