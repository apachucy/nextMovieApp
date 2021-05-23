package unii.entertainment.movie.movieapp.core.di

import org.koin.dsl.module
import unii.entertainment.movie.movieapp.core.data.remote.MovieListDataSource
import unii.entertainment.movie.movieapp.core.data.remote.MovieListDataSourceImpl
import unii.entertainment.movie.movieapp.core.repo.MovieRepo
import unii.entertainment.movie.movieapp.core.repo.MovieRepoImpl

val repoModule = module {
    single<MovieListDataSource> { MovieListDataSourceImpl() }
    single<MovieRepo> { MovieRepoImpl() }
}