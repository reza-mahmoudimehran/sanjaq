package ir.rezamahmoudi.divar.core.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.rezamahmoudi.divar.core.domain.datastore.DataStoreRepository
import ir.rezamahmoudi.divar.core.util.constant.CoreConstants.DATA_STORE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(DATA_STORE_NAME)

class DataStoreRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : DataStoreRepository {

    private val dataStore = context.dataStore

    override suspend fun <T> save(key: Preferences.Key<T>, value: T) {
        dataStore.edit {
            it[key] = value
        }
    }

    override fun <T> read(key: Preferences.Key<T>): Flow<T?> = dataStore.data.map { it[key] }

    override suspend fun <T> remove(key: Preferences.Key<T>) {
        dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }

    override suspend fun clearPrefs() {
        dataStore.edit { it.clear() }
    }
}
