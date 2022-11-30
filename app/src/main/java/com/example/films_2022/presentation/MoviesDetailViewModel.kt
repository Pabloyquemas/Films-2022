package com.example.films_2022.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.films_2022.domain.GetMoviesDetailUseCase
import com.example.films_2022.domain.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesDetailViewModel(private val getMoviesDetailUseCase: GetMoviesDetailUseCase): ViewModel() {

    val moviesFeedPublisherdetail: MutableLiveData<moviesDetailUiState> by lazy {
        MutableLiveData<moviesDetailUiState>()
    }

    fun loadMoviesDetail(moviesId: String){
        moviesFeedPublisherdetail.value = moviesDetailUiState()

        viewModelScope.launch(Dispatchers.IO) {
            val moviesdetailfeed = getMoviesDetailUseCase.execute(moviesId)
            moviesFeedPublisherdetail.postValue(
                moviesDetailUiState(
                    moviesFeedDetail = moviesdetailfeed

                )
            )
        }
    }

    data class moviesDetailUiState(
        val moviesFeedDetail: GetMoviesDetailUseCase.Moviesbyid? = null
    )

}