package ir.rezamahmoudi.divar.core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel

@Composable
fun WidgetItem(
    modifier: Modifier = Modifier,
    widget: WidgetUiModel
) {
    when (widget) {
        is WidgetSubTitleRowUiModel -> {
            Text(
                modifier = Modifier.background(color = Color.Green),
                text = "${widget.data.text}"
            )
        }
        is WidgetTitleRowUiModel -> {
            Text(modifier = Modifier.background(color = Color.Red), text = "${widget.data.text}")
        }
        is WidgetPostRowUiModel -> {
            Text(text = "${widget.data.title}")
        }
    }
}
