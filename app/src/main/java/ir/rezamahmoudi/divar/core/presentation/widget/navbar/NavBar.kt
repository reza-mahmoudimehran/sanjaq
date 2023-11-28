package ir.rezamahmoudi.divar.core.presentation.widget.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.designsystem.ThemePreviews
import ir.rezamahmoudi.divar.core.util.compose.PreviewWrapper

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    text: String,
    navigateUp: () -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .background(color = AppTheme.colors.designSystem.primaryBackground)
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .clickable {
                            navigateUp()
                        },
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = null,
                    tint = AppTheme.colors.designSystem.primaryIconTint
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
                    color = AppTheme.colors.designSystem.primaryText,
                    style = AppTheme.typography.text14Medium
                )
            }
            Divider(thickness = 1.dp, color = AppTheme.colors.designSystem.primaryDivider)
        }
    }
}

@ThemePreviews
@Composable
fun PreviewNavBar() {
    PreviewWrapper {
        NavBar(
            text = "جزییات آگهی",
            navigateUp = {}
        )
    }
}
