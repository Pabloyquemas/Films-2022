package com.example.films_2022.domain

class GetMoviesUseCase(
    private val MoviesRepository : MoviesRepository
) {
    fun execute(): List<Movies>{
        val movies = MoviesRepository.getmovies()
        return movies
    }
}