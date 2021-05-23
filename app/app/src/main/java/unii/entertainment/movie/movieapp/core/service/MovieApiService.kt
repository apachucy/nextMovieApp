package unii.entertainment.movie.movieapp.core.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import unii.entertainment.movie.movieapp.core.data.remote.MovieDetailResponse
import unii.entertainment.movie.movieapp.core.data.remote.MovieListResponse
import unii.entertainment.movie.movieapp.core.data.remote.TmdbApiResponse

interface MovieApiService {

    @GET("movie/{list}")
    suspend fun fetchMovieList(
        @Path("list") list: String,
        @Query("page") page: Int? = null
    ): TmdbApiResponse<MovieListResponse>

    @GET("movie/{movieId}")
    suspend fun fetchMovieDetail(@Path("movieId") movieId: String): MovieDetailResponse

}