package ir.rezamahmoudi.divar.cityselection.data.datasource.local

import ir.rezamahmoudi.divar.cityselection.data.entity.CitiesEntity

interface CitySelectionLocalDataSource {
    suspend fun getAllCities(): Result<List<CitiesEntity>>
    suspend fun insertCities(cities: List<CitiesEntity>): Result<Unit>
}
