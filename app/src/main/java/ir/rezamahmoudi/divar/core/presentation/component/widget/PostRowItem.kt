package ir.rezamahmoudi.divar.core.presentation.component.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.designsystem.ThemePreviews
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.core.presentation.widget.image.NetworkImage
import ir.rezamahmoudi.divar.core.util.compose.PreviewWrapper

@Composable
fun PostRowItem(
    modifier: Modifier = Modifier,
    post: WidgetPostRowDataUiModel,
    onNavigateToScreen: (String) -> Unit
) {
    Column(
        modifier = modifier.clickable {
            onNavigateToScreen(Screen.PostDetails.createRoute(postToken = post.token))
        }
            .padding(vertical = 4.dp, horizontal = AppTheme.dimensions.mainContentPadding)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 12.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = post.title,
                    style = AppTheme.typography.text14Bold,
                    color = AppTheme.colors.designSystem.primaryText,
                    maxLines = 2
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = post.price,
                    style = AppTheme.typography.text12Medium,
                    color = AppTheme.colors.designSystem.primaryText,
                    maxLines = 2
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = post.district,
                    style = AppTheme.typography.text12Medium,
                    color = AppTheme.colors.designSystem.primaryText,
                    maxLines = 1
                )
            }

            NetworkImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                imageModifier = Modifier.fillMaxSize(),
                url = post.thumbnail
            )
        }
        Divider(color = AppTheme.colors.designSystem.primaryDivider)
    }
}

@ThemePreviews
@Composable
fun PostRowItemPreview() {
    PreviewWrapper {
        PostRowItem(
            post = WidgetPostRowDataUiModel.EMPTY.copy(
                title = "۸۰ متر ۲خ    ۲پارکینگ    کامل تراورتن   کم واحد",
                price = "۷,۲۵۰,۰۰۰,۰۰۰ تومان",
                district = "آژانس املاک دفتر املاک مان در پونک"
            ),
            onNavigateToScreen = {}
        )
    }
}
