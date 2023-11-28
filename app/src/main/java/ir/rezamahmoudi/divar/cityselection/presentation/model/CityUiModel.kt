package ir.rezamahmoudi.divar.cityselection.presentation.model

import androidx.compose.runtime.Stable
import ir.rezamahmoudi.divar.core.data.model.Domain

@Stable
data class CityUiModel(
    val id: Int,
    val name: String,
    val slug: String,
    val radius: Int,
    val centroid: CentroidUiModel
) : Domain {
    companion object {
        val EMPTY = CityUiModel(
            id = 0,
            name = "",
            slug = "",
            radius = 0,
            centroid = CentroidUiModel.EMPTY
        )
    }
}

@Stable
data class CentroidUiModel(
    val latitude: String,
    val longitude: String
) : Domain {
    companion object {
        val EMPTY = CentroidUiModel(
            latitude = "",
            longitude = ""
        )
    }
}
