package com.example.films_2022.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.films_2022.domain.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesFeedViewModel(getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    fun loadMovies(getMoviesUseCase: GetMoviesUseCase){
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase.execute()
        }

    }

}