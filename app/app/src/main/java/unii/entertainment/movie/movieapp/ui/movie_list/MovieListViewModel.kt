package unii.entertainment.movie.movieapp.ui.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.repo.MovieRepo
import unii.entertainment.movie.movieapp.core.utils.MovieCategory
import unii.entertainment.movie.movieapp.core.utils.Resource

class MovieListViewModel : ViewModel(), KoinComponent {

    private val repo: MovieRepo by inject()

    val fetchMoviesList = liveData<Resource<List<MovieModel>>>(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.fetchMovieList(MovieCategory.TOP_RATED.key, 1))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}