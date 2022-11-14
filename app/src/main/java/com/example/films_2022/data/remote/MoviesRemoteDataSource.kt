package com.example.films_2022.data.remote

import com.example.films_2022.data.remote.Api.MoviesApiModel
import com.example.films_2022.domain.Movies

interface MoviesRemoteDataSource {
    fun getMovies(): List<Movies>
    fun getmoviesbyId(movieId: String): Movies?
}