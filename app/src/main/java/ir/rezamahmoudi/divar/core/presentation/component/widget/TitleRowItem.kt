package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowDataUiModel
import ir.rezamahmoudi.divar.core.util.test.TestTagConstants.TITLE_ROW_ITEM_TEST_TAG

@Composable
fun TitleRowItem(
    modifier: Modifier = Modifier,
    title: WidgetTitleRowDataUiModel
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AppTheme.colors.designSystem.primaryBackground)
            .padding(vertical = 12.dp, horizontal = AppTheme.dimensions.mainContentPadding)
            .testTag(TITLE_ROW_ITEM_TEST_TAG),
        text = title.text,
        style = AppTheme.typography.text16ExtraBold,
        color = AppTheme.colors.designSystem.primaryText
    )
}
