package unii.entertainment.movie.movieapp.core.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeViewVisibility(view: View, bool: LiveData<Boolean>) {
        view.visibility = if (bool.value == true) View.VISIBLE else View.INVISIBLE
    }
}