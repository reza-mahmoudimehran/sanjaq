package ir.rezamahmoudi.divar.cityselection.util.fakedata

import ir.rezamahmoudi.divar.cityselection.data.model.CentroidDto
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams

val CENTROID_DTO_TEST_OBJECT = CentroidDto(
    latitude = "latitude",
    longitude = "longitude"
)

val CITY_DTO_TEST_OBJECT = CityDto(
    id = 1234,
    name = "name",
    slug = "slug",
    radius = 100,
    centroid = CENTROID_DTO_TEST_OBJECT
)

val FIND_CURRENT_CITY_PARAMS_TEST_OBJECT = FindCurrentCityParams(0.0, 0.0)
