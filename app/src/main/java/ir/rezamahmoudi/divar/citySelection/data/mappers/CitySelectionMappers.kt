package ir.rezamahmoudi.divar.cityselection.data.mappers

import ir.rezamahmoudi.divar.cityselection.data.entity.CityEntity
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun List<CityEntity>.asDomain(): ImmutableList<CityUiModel> = map {
    CityUiModel(
        id = it.id,
        name = it.name,
        slug = it.slug,
        radius = it.radius,
        centroid = it.centroid.asDomain()
    )
}.toImmutableList()

fun List<CityDto>.mapToEntity(): List<CityEntity> = map {
    CityEntity(
        id = it.id,
        name = it.name,
        slug = it.slug,
        radius = it.radius,
        centroid = it.centroid
    )
}
