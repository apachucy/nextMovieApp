package unii.entertainment.movie.movieapp.core.di

import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import unii.entertainment.movie.movieapp.ui.movie_detail.MovieDetailFragment
import unii.entertainment.movie.movieapp.ui.movie_detail.MovieDetailViewModel
import unii.entertainment.movie.movieapp.ui.movie_list.MovieListFragment
import unii.entertainment.movie.movieapp.ui.movie_list.MovieListViewModel
import unii.entertainment.movie.movieapp.ui.splash.SplashFragment
import unii.entertainment.movie.movieapp.ui.splash.SplashViewModel

val appModule = module {
}

val fragmentModule = module {
    fragment { SplashFragment() }
    fragment { MovieListFragment() }
    fragment { MovieDetailFragment() }
}

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { MovieListViewModel() }
    viewModel { MovieDetailViewModel() }
}