package unii.entertainment.movie.movieapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import unii.entertainment.movie.movieapp.ui.movie_list.MovieListAdapter

@RunWith(AndroidJUnit4::class)
class FullAppFlowTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup() {
        //TODO: Fix me - not the cleanest solution
        Thread.sleep(6000)
    }

    @Test
    fun fromOpeningAppToDetailScreen() {
        onView(withId(R.id.movie_list_recyclerView))
            .check(matches(isDisplayed()))
        onView(withId(R.id.movie_list_recyclerView))
            .perform(actionOnItemAtPosition<MovieListAdapter.MovieListViewHolder>(0, click()))


        onView(withId(R.id.movie_title)).check(matches(withText("Dilwale Dulhania Le Jayenge")))
        onView(withId(R.id.movie_description))
            .check(
                matches(
                    withText(containsString("Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood")),
                )
            )
    }

    @Test
    fun goBackToListFromDetailScreen() {
        onView(withId(R.id.movie_list_recyclerView))
            .check(matches(isDisplayed()))
        onView(withId(R.id.movie_list_recyclerView))
            .perform(actionOnItemAtPosition<MovieListAdapter.MovieListViewHolder>(0, click()))

        pressBack()
        onView(withId(R.id.movie_list_recyclerView))
            .check(matches(isDisplayed()))
    }
}
