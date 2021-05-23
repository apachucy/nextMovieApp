package unii.entertainment.movie.movieapp.ui.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import unii.entertainment.movie.movieapp.R
import unii.entertainment.movie.movieapp.core.data.model.MovieModel
import unii.entertainment.movie.movieapp.core.utils.Resource
import unii.entertainment.movie.movieapp.databinding.MovieListFragmentBinding

class MovieListFragment : Fragment() {
    companion object {
        const val bundleKeyMovie: String = "movieId"
    }

    private var _binding: MovieListFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieListViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            MovieListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupRefreshListener()
        observe()
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setupRefreshListener() {
        binding.movieListSwiperefresh.setOnRefreshListener {
            viewModel.fetchMovieList()
            binding.movieListSwiperefresh.isRefreshing = false
        }
    }

    private fun observe() {
        viewModel.movieListResponse.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.movieListProgress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.movieListProgress.visibility = View.GONE

                    (binding.movieListRecyclerView.adapter as MovieListAdapter).setData(result.data)
                }
                is Resource.Failure -> {
                    binding.movieListProgress.visibility = View.GONE

                    Toast.makeText(
                        requireContext(),
                        getString(R.string.network_error, result.exception),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.movieListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.movieListRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.movieListRecyclerView.adapter = MovieListAdapter(
            listOf<MovieModel>().toMutableList(),
            object : MovieListAdapter.OnMovieClickListener {
                override fun onMovieClick(id: String) {
                    moveToNextView(id)
                }
            })

    }

    private fun moveToNextView(movieId: String) {
        val bundle = bundleOf(bundleKeyMovie to movieId)
        findNavController().navigate(
            R.id.action_movieListFragment_to_movieDetailFragment,
            bundle
        )
    }
}