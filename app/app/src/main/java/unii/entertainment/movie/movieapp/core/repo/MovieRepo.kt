package unii.entertainment.movie.movieapp.core.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.data.remote.MovieListDataSource
import unii.entertainment.movie.movieapp.core.data.remote.MovieListResponse
import unii.entertainment.movie.movieapp.core.data.remote.mapToMovieModel
import unii.entertainment.movie.movieapp.core.data.remote.mapToMovieModels
import unii.entertainment.movie.movieapp.core.utils.Resource


interface MovieRepo {
    suspend fun fetchMovieList(
        list: String,
        page: Int?
    ): Resource<List<MovieModel>>

    suspend fun fetchMovieDetail(movieId: String): Resource<MovieModel>
}

class MovieRepoImpl : MovieRepo, KoinComponent {

    private val movieListDataSource: MovieListDataSource by inject()
    override suspend fun fetchMovieList(
        list: String,
        page: Int?
    ): Resource<List<MovieModel>> {
        return withContext(Dispatchers.IO) {
            val response = movieListDataSource.fetchMovieList(list, page)
            if (response is Resource.Success) {
                Resource.Success((response.data.results as List<MovieListResponse>).mapToMovieModels())
            } else Resource.Failure(Exception("Could not parse model"))
        }
    }

    override suspend fun fetchMovieDetail(movieId: String): Resource<MovieModel> {
        return withContext(Dispatchers.IO) {
            val response = movieListDataSource.fetchMovieDetail(movieId)
            if (response is Resource.Success) {
                Resource.Success((response.data).mapToMovieModel())
            } else Resource.Failure(Exception("Could not parse model"))
        }
    }

}