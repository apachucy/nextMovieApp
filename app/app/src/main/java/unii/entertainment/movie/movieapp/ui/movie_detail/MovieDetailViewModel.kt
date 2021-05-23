package unii.entertainment.movie.movieapp.ui.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.repo.MovieRepo
import unii.entertainment.movie.movieapp.core.utils.Resource

class MovieDetailViewModel : ViewModel(), KoinComponent {
    private val repo: MovieRepo by inject()

    fun fetchDetails(movieId: String) = liveData<Resource<MovieModel>>(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.fetchMovieDetail(movieId))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}