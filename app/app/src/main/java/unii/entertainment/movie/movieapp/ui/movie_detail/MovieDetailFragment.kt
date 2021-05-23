package unii.entertainment.movie.movieapp.ui.movie_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import unii.entertainment.movie.movieapp.R
import unii.entertainment.movie.movieapp.core.utils.Resource
import unii.entertainment.movie.movieapp.databinding.MovieDetailFragmentBinding
import unii.entertainment.movie.movieapp.ui.movie_list.MovieListFragment

class MovieDetailFragment : Fragment() {
    private val viewModel: MovieDetailViewModel by inject()
    private var _binding: MovieDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val fallbackMovieId = "1"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            MovieDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchDetails(
            arguments?.getString(MovieListFragment.bundleKeyMovie) ?: fallbackMovieId
        ).observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.movieDetailProgress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.movieDetailProgress.visibility = View.GONE
                    binding.item = result.data
                }
                is Resource.Failure -> {
                    binding.movieDetailProgress.visibility = View.GONE

                    Toast.makeText(
                        requireContext(),
                        getString(R.string.network_error, result.exception),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })


    }
}