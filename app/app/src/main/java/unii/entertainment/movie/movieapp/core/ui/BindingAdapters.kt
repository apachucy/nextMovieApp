package unii.entertainment.movie.movieapp.core.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeViewVisibility(view: View, bool: LiveData<Boolean>) {
        view.visibility = if (bool.value == true) View.VISIBLE else View.INVISIBLE
    }


    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

    @JvmStatic
    @BindingAdapter("imageUrlIf")
    fun loadImageIf(view: ImageView, url: String?) {
        url.let {
            Glide.with(view.context).load(it).into(view)
        }
    }
}