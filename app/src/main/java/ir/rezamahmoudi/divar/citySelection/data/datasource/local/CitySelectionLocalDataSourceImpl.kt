package ir.rezamahmoudi.divar.cityselection.data.datasource.local

import ir.rezamahmoudi.divar.cityselection.data.entity.CitiesEntity
import javax.inject.Inject

class CitySelectionLocalDataSourceImpl @Inject constructor(
    private val dao: CitySelectionDao
) : CitySelectionLocalDataSource {
    override suspend fun getAllCities(): Result<List<CitiesEntity>> =
        runCatching { dao.getAllCities() }

    override suspend fun insertCities(cities: List<CitiesEntity>): Result<Unit> =
        runCatching { dao.insertCities(cities = cities) }
}
