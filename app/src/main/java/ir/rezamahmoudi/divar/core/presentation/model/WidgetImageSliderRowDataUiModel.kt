package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable
import ir.rezamahmoudi.divar.core.data.model.Domain
import kotlinx.collections.immutable.ImmutableList

@Stable
data class WidgetImageSliderRowDataUiModel(
    val items: ImmutableList<ImageSliderItemUiModel>
) : WidgetDataUiModel

@Stable
data class ImageSliderItemUiModel(
    val imageUrl: String
) : Domain
