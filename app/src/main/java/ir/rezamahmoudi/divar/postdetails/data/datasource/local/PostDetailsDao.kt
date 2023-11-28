package ir.rezamahmoudi.divar.postdetails.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.POST_DETAILS_TABLE_NAME
import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity

@Dao
interface PostDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostDetails(postDetails: PostDetailsEntity)

    @Query("SELECT * FROM $POST_DETAILS_TABLE_NAME where post_token = :postToken")
    suspend fun getPostDetails(postToken: String): PostDetailsEntity
}
