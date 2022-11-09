package com.example.films_2022.data.local

import com.example.films_2022.domain.Movies

interface MoviesLocalDataSource {
    fun save(Movies: List<Movies>)
    fun GetMovies(): List<Movies>
    fun GetMovie(movieId: String): Movies?
}