package com.example.films_2022.data.remote.Api

data class MoviesApiModel(
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Double,
    val year: String,
    val poster: String
)
