package com.example.films_2022.presentation

import android.os.Bundle
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films_2022.databinding.FragmentMoviesFeedBinding
import com.example.films_2022.presentation.adapter.MoviesAdapter

class MoviesFeedFragment: Fragment() {

    private var _binding: FragmentMoviesFeedBinding? = null
    private val MoviesAdapter = MoviesAdapter()
    private val viewModel by lazy {
        MoviesFactory().getMoviesViewModel(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesFeedBinding.inflate(inflater, container, false)
        val view = _binding?.root
        setupView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadMovies()
    }

    fun setupView(){
        _binding?.apply {
            listmoviesfeed.apply {
                adapter = MoviesAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
                MoviesAdapter.setOnClickItem {
                    navigateToDetail(it)
                }
            }
        }
    }

    private fun setupObservers(){
        val moviesFeedSubscriber =
            Observer<MoviesFeedViewModel.moviesUiState>{ uiState ->
                MoviesAdapter.setDataItems(uiState.moviesFeed)
            }
        viewModel.moviesFeedPublisher.observe(viewLifecycleOwner, moviesFeedSubscriber)
    }

    private fun navigateToDetail(movieId: String){
        findNavController().navigate()
    }


}