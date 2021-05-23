package unii.entertainment.movie.movieapp.core.service.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import unii.entertainment.movie.movieapp.BuildConfig

class ApiKeyInterceptor : Interceptor {
    private val apiKey: String = "api_key"
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(apiKey, BuildConfig.API_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}