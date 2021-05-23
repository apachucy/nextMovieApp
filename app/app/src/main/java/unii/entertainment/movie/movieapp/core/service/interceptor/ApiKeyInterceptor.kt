package unii.entertainment.movie.movieapp.core.service.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    private val apiKeyValue: String = "edec99ee81a5e1ddcbd0e809b029cc9d"
    private val apiKey: String = "api_key"
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(apiKey, apiKeyValue).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}