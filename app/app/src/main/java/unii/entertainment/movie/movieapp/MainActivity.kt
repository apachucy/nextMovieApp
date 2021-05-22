package unii.entertainment.movie.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.core.KoinExperimentalAPI
import unii.entertainment.movie.movieapp.ui.splash.SplashFragment

class MainActivity : AppCompatActivity() {

    @KoinExperimentalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        // Koin Fragment Factory
        setupKoinFragmentFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SplashFragment.newInstance())
                    .commitNow()
        }
    }
}