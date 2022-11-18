package com.example.films_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.films_2022.domain.GetMoviesUseCase
import com.example.films_2022.domain.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesFeedViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    val moviesFeedPublisher: MutableLiveData<moviesUiState> by lazy {
        MutableLiveData<moviesUiState>()
    }

    fun loadMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val moviesfeed = getMoviesUseCase.execute()
            moviesFeedPublisher.postValue(
                moviesUiState(
                    isLoading = false,
                    moviesFeed = moviesfeed

                )
            )
        }
    }

    data class moviesUiState(
        val isLoading: Boolean = false,
        val moviesFeed: List<Movies> = emptyList()
    )
}