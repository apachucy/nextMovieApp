package unii.entertainment.movie.movieapp.core.data.remote

import com.google.gson.annotations.SerializedName
import unii.entertainment.movie.movieapp.core.data.model.Genre
import unii.entertainment.movie.movieapp.core.data.model.MovieModel

data class MovieDetailResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Float?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("genres")
    val genreList: List<Genre>?,
    @SerializedName("runtime")
    val runtime: Int?
)

fun MovieDetailResponse.mapToMovieModel(): MovieModel =
    MovieModel(
        id = id,
        posterPath = posterPath,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
        releaseDate = releaseDate,
        overview = overview
    )

