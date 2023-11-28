package ir.rezamahmoudi.divar.cityselection.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.rezamahmoudi.divar.cityselection.data.entity.CityEntity
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.CITIES_TABLE_NAME

@Dao
interface CitySelectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(cities: List<CityEntity>)

    @Query("SELECT * FROM $CITIES_TABLE_NAME")
    suspend fun getAllCities(): List<CityEntity>
}
