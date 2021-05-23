package unii.entertainment.movie.movieapp.core.di

import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import unii.entertainment.movie.movieapp.BuildConfig.BASE_URL
import unii.entertainment.movie.movieapp.BuildConfig.FLAVOR
import unii.entertainment.movie.movieapp.core.service.MovieApiService
import unii.entertainment.movie.movieapp.core.service.interceptor.ApiKeyInterceptor
import unii.entertainment.movie.movieapp.core.service.interceptor.MockInterceptor

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single { ApiKeyInterceptor() }
    single { MockInterceptor() }
    single {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(get<HttpLoggingInterceptor>())
        if (FLAVOR != "apiProduction") {
            builder.addInterceptor(get<MockInterceptor>())
        }
        builder.addInterceptor(get<ApiKeyInterceptor>())
        builder.protocols(listOf(Protocol.HTTP_1_1, Protocol.HTTP_2))
        builder.build()
    }

    single<Converter.Factory> { GsonConverterFactory.create() }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
    }
}

val apiModule = module {
    single { get<Retrofit>().create(MovieApiService::class.java) }
}
