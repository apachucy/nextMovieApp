package unii.entertainment.movie.movieapp.ui.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.utils.ListDiffUtils
import unii.entertainment.movie.movieapp.databinding.RowMovieBinding

class MovieListAdapter(
    private val moviesList: MutableList<MovieModel>,
    private val itemClickListener: OnMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(id: String)
    }

    fun setData(newList: List<MovieModel>) {
        val diffCallback = ListDiffUtils(moviesList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        moviesList.clear()
        moviesList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val inflater = LayoutInflater.from(parent.context)
        val binding = RowMovieBinding.inflate(inflater, parent, false)
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MovieListViewHolder -> holder.bind(moviesList[position], position)
        }
    }

    inner class MovieListViewHolder(private val binding: RowMovieBinding) :
        BaseViewHolder<MovieModel>(binding) {
        override fun bind(item: MovieModel, position: Int) {
            binding.item = item
            binding.root.setOnClickListener { itemClickListener.onMovieClick(item.id) }
        }
    }
}

abstract class BaseViewHolder<T>(itemView: RowMovieBinding) :
    RecyclerView.ViewHolder(itemView.root) {
    abstract fun bind(item: T, position: Int)
}