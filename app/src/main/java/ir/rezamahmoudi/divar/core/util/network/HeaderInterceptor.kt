package ir.rezamahmoudi.divar.core.util.network

import ir.rezamahmoudi.divar.core.util.constant.CoreConstants.API_ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val chainBuilder = chain.request().newBuilder()
        chainBuilder.addHeader("content-type", "application/json")
        chainBuilder.addHeader("x-access-token", API_ACCESS_TOKEN)
        return chain.proceed(chainBuilder.build())
    }
}
