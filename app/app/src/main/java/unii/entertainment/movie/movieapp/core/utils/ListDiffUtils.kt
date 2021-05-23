package unii.entertainment.movie.movieapp.core.utils

import androidx.recyclerview.widget.DiffUtil
import unii.entertainment.movie.movieapp.core.data.model.MovieModel

class ListDiffUtils(private val old: List<MovieModel>, private val new: List<MovieModel>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int =
        old.size


    override fun getNewListSize(): Int = new.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].id == new[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].title == new[newItemPosition].title
    }
}