package ir.rezamahmoudi.divar.cityselection.data.mappers

import ir.rezamahmoudi.divar.cityselection.data.entity.CitiesEntity
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun List<CitiesEntity>.asDomain(): ImmutableList<CityUiModel> = map {
    CityUiModel(
        id = it.id,
        name = it.name,
        slug = it.slug,
        radius = it.radius,
        centroid = it.centroid.asDomain()
    )
}.toImmutableList()

fun List<CityDto>.mapToEntity(): List<CitiesEntity> = map {
    CitiesEntity(
        id = it.id,
        name = it.name,
        slug = it.slug,
        radius = it.radius,
        centroid = it.centroid
    )
}
