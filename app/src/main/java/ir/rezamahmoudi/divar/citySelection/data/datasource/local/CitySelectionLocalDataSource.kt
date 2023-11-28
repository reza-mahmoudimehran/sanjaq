package ir.rezamahmoudi.divar.cityselection.data.datasource.local

import ir.rezamahmoudi.divar.cityselection.data.entity.CityEntity

interface CitySelectionLocalDataSource {
    suspend fun getAllCities(): Result<List<CityEntity>>
    suspend fun insertCities(cities: List<CityEntity>): Result<Unit>
}
