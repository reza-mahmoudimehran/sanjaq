package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowDataUiModel

@Composable
fun TitleRowItem(
    modifier: Modifier = Modifier,
    title: WidgetTitleRowDataUiModel
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        text = title.text,
        style = AppTheme.typography.text16ExtraBold,
        color = AppTheme.colors.designSystem.primaryText
    )
}
