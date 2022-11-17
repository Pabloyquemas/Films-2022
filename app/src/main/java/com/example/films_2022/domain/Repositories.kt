package com.example.films_2022.domain

interface MoviesRepository {
    fun getmovies(): List <Movies>
    fun getmoviesbyId(MoviesId: String): Movies?
}