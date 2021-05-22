package unii.entertainment.movie.movieapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import unii.entertainment.movie.movieapp.core.di.appModule
import unii.entertainment.movie.movieapp.core.di.fragmentModule
import unii.entertainment.movie.movieapp.core.di.viewModelModule

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            fragmentFactory()
            modules(defineDependencies())
        }
    }


    private fun defineDependencies(): List<Module> =
        listOf(appModule, fragmentModule, viewModelModule)
}