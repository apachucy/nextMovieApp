package unii.entertainment.movie.movieapp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private var _shouldInitApp: MutableLiveData<Boolean> = MutableLiveData(true)

    companion object {
        const val progressbarDelay: Long = 5_000
    }

    val initApp: LiveData<Boolean>
        get() = _shouldInitApp


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(progressbarDelay)
            _shouldInitApp.value = false
        }
    }
}