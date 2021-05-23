package unii.entertainment.movie.movieapp.ui.movie_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.repo.MovieRepo
import unii.entertainment.movie.movieapp.core.utils.MovieCategory
import unii.entertainment.movie.movieapp.core.utils.Resource

class MovieListViewModel : ViewModel(), KoinComponent {

    private val repo: MovieRepo by inject()

    val movieListResponse = MutableLiveData<Resource<List<MovieModel>>>()
    init {
        fetchMovieList()
    }

    fun fetchMovieList() {
        viewModelScope.launch {
            movieListResponse.value = Resource.Loading()
            try {
                movieListResponse.value = repo.fetchMovieList(MovieCategory.TOP_RATED.key, 1)
            } catch (e: Exception) {
                movieListResponse.value = Resource.Failure(e)
            }
        }
    }

}