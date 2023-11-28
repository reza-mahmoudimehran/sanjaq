package ir.rezamahmoudi.divar.cityselection.data.datasource.local

import ir.rezamahmoudi.divar.cityselection.data.entity.CityEntity
import javax.inject.Inject

class CitySelectionLocalDataSourceImpl @Inject constructor(
    private val dao: CitySelectionDao
) : CitySelectionLocalDataSource {
    override suspend fun getAllCities(): Result<List<CityEntity>> =
        runCatching { dao.getAllCities() }

    override suspend fun insertCities(cities: List<CityEntity>): Result<Unit> =
        runCatching { dao.insertCities(cities = cities) }
}
