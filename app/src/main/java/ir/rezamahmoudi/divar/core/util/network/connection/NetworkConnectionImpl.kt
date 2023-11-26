package ir.rezamahmoudi.divar.core.util.network.connection

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkConnectionImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NetworkConnection {
    override fun isConnected(): Boolean = context.isConnected()
}
