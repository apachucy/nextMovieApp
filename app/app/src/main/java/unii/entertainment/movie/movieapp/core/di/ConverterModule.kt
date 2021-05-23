package unii.entertainment.movie.movieapp.core.di

import com.google.gson.Gson
import org.koin.dsl.module

val gsonModule = module {
    single { Gson() }
}