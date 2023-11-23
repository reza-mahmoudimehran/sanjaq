package ir.rezamahmoudi.divar.core.domain.datastore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun <T> save(key: Preferences.Key<T>, value: T)
    fun <T> read(key: Preferences.Key<T>): Flow<T?>
    suspend fun <T> remove(key: Preferences.Key<T>)
    suspend fun clearPrefs()
}
