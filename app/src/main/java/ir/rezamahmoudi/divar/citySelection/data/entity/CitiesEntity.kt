package ir.rezamahmoudi.divar.cityselection.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.rezamahmoudi.divar.cityselection.data.model.CentroidDto
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.CITIES_TABLE_NAME

@Entity(
    tableName = CITIES_TABLE_NAME
)
data class CitiesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val slug: String,
    val radius: Int,
    @Embedded
    val centroid: CentroidDto
)
