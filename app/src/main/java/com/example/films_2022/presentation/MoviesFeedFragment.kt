package com.example.films_2022.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.films_2022.R
import com.example.films_2022.databinding.FragmentMoviesFeedBinding
import com.example.films_2022.domain.GetMoviesUseCase
import com.example.films_2022.domain.MoviesRepository
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
        viewModel.loadMovies()
    }

    fun setupView(){
        _binding?.apply {
            listmoviesfeed.apply {
                adapter = MoviesAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            }
        }
    }

}