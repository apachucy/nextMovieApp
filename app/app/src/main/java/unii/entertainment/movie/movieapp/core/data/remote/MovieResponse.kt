package unii.entertainment.movie.movieapp.core.data.remote

import com.google.gson.annotations.SerializedName
import unii.entertainment.movie.movieapp.core.data.model.MovieModel

data class MovieListResponse(
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
    @SerializedName("release_date")
    val releaseDate: String?
)

fun List<MovieListResponse>.mapToMovieModels(): List<MovieModel> =
    this.map {
        MovieModel(
            id = it.id,
            posterPath = it.posterPath,
            title = it.title,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount,
            releaseDate = it.releaseDate
        )
    }


