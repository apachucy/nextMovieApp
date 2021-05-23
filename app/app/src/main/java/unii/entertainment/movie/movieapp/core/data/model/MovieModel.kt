package unii.entertainment.movie.movieapp.core.data.model

import unii.entertainment.movie.movieapp.core.utils.format
import unii.entertainment.movie.movieapp.core.utils.formatHourMinutes


const val PLACEHOLDER = "--"

data class MovieModel(
    val id: String,
    val posterPath: String? = null,
    val title: String? = null,
    val voteAverage: Float? = null,
    val voteCount: Int? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val genreList: List<Genre>? = null,
    val runtime: Int? = null
) {
    fun posterUrl(): String = "https://image.tmdb.org/t/p/w500/${this.posterPath}"
    fun displayTitle(): String = this.title ?: PLACEHOLDER
    fun display5StarsRating(): String = (this.voteAverage?.div(2) ?: 0.0f).toString()
    fun displayVoteCount(): String = this.voteCount?.format() ?: PLACEHOLDER

    fun displayVotePercentage(): String = "${this.voteAverage?.times(10) ?: PLACEHOLDER}%"

    fun displayDuration(): String = this.runtime?.formatHourMinutes() ?: PLACEHOLDER
    fun displayReleaseDate(): String = this.releaseDate ?: PLACEHOLDER
    fun displayOverview(): String = this.overview ?: PLACEHOLDER
}

