package com.example.films_2022.domain

interface MoviesRepository {
    fun GetMovies(): List <Movies>
    fun GetMoviesById(MoviesId: String): Movies?
}