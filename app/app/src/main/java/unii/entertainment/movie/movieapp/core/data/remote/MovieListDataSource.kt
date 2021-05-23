package unii.entertainment.movie.movieapp.core.data.remote

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import unii.entertainment.movie.movieapp.core.service.MovieApiService
import unii.entertainment.movie.movieapp.core.utils.Resource


//TODO: Paging ?
interface MovieListDataSource {
    suspend fun fetchMovieList(
        list: String,
        page: Int?
    ): Resource<TmdbApiResponse<MovieListResponse>>

    suspend fun fetchMovieDetail(movieId: String): Resource<MovieDetailResponse>
}

class MovieListDataSourceImpl
    : MovieListDataSource, KoinComponent {

    private val api: MovieApiService by inject()


    override suspend fun fetchMovieList(
        list: String,
        page: Int?
    ): Resource<TmdbApiResponse<MovieListResponse>> {
        return Resource.Success(api.fetchMovieList(list, page))
    }


    override suspend fun fetchMovieDetail(movieId: String): Resource<MovieDetailResponse> {
        return Resource.Success(api.fetchMovieDetail(movieId))
    }
}
