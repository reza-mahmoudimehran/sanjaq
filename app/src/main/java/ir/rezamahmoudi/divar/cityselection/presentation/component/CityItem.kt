package ir.rezamahmoudi.divar.cityselection.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme

@Composable
fun CityItem(
    modifier: Modifier = Modifier,
    city: CityUiModel,
    onSelectCity: (cityId: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onSelectCity(city.id.toString())
                }
                .padding(vertical = 12.dp, horizontal = 2.dp),
            text = city.name,
            style = AppTheme.typography.text14Bold,
            color = AppTheme.colors.designSystem.primaryText
        )
        Divider(color = AppTheme.colors.designSystem.primaryDivider)
    }
}
