package com.example.films_2022.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.extensions.loadUrl
import com.example.films_2022.databinding.FragmentMoviesDetailBinding
import com.example.films_2022.databinding.ViewItemMoviesDetailBinding
import com.example.films_2022.domain.GetMoviesDetailUseCase

class MoviesDetailFragment : Fragment() {

    private var _binding: FragmentMoviesDetailBinding? = null
    private var viewModel: MoviesDetailViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesDetailBinding.inflate(inflater)
        val view = _binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MoviesFactory().getMoviesDetailViewModel(requireContext())
        setupObserver()
        viewModel?.loadMoviesDetail(arguments?.getString("movieId") ?: "error")

    }

    private fun setupObserver(){
        val movieDetailsFragment =
            Observer<MoviesDetailViewModel.moviesDetailUiState>{ UiDetailstate ->
                UiDetailstate.moviesFeedDetail?.let {
                    bind(it)
                }
            }
        viewModel?.moviesFeedPublisherdetail?.observe(viewLifecycleOwner, movieDetailsFragment)
    }

    fun bind (movie: GetMoviesDetailUseCase.Moviesbyid){
        _binding?.apply {
            movieDetailFragment.genre.text = movie.genre
            movieDetailFragment.title.text = movie.title
            movieDetailFragment.year.text = movie.year
            movieDetailFragment.poster.loadUrl(movie.poster)
        }
    }
}