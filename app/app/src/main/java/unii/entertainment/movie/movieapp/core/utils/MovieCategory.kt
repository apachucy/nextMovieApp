package unii.entertainment.movie.movieapp.core.utils

import androidx.annotation.StringRes
import unii.entertainment.movie.movieapp.R

enum class MovieCategory(val key: String, @StringRes val strRes: Int) {
    NOW_PLAYING("now_playing", R.string.category_now_playing),
    POPULAR("popular", R.string.category_popular),
    TOP_RATED("top_rated", R.string.category_top_rated),
    UPCOMING("upcoming", R.string.category_upcoming);
}