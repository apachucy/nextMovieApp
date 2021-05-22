package unii.entertainment.movie.movieapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import unii.entertainment.movie.movieapp.R
import unii.entertainment.movie.movieapp.databinding.SplashFragmentBindingImpl

class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: SplashFragmentBindingImpl =
            DataBindingUtil.inflate(inflater, R.layout.splash_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        viewModel.initApp.observe(this@SplashFragment.viewLifecycleOwner, { init ->
            if (init) {
                //TODO: go away from this view
            }
        })
    }

}