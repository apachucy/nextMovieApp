package unii.entertainment.movie.movieapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import unii.entertainment.movie.movieapp.ui.splash.SplashViewModel
import unii.entertainment.movie.movieapp.util.MainCoroutineScopeRule

class SplashScreenVMTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    lateinit var subject: SplashViewModel

    @Before
    fun setup() {

    }
    @After
    fun after() {
        subject.viewModelScope.cancel()
    }
    @Test
    fun triggerHideSplashScreenAfterDelay() {

        //given
        subject = SplashViewModel()
        Truth.assertThat(subject.initApp.value).isEqualTo(true)

        //when
        coroutineScope.advanceTimeBy(SplashViewModel.progressbarDelay)

        //then
        Truth.assertThat(subject.initApp.value).isEqualTo(false)

    }

    @Test
    fun shouldNotTriggerHideSplashScreenAfter5000() {
        //given
        subject = SplashViewModel()
        Truth.assertThat(subject.initApp.value).isEqualTo(true)
        //when
        coroutineScope.advanceTimeBy(1000)

        //then
        Truth.assertThat(subject.initApp.value).isEqualTo(true)

    }
}