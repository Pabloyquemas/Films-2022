package com.example.films_2022.domain

class GetMoviesUseCase(
    private val MoviesRepository : MoviesRepository
) {
    fun execute(): List<Movies>{
        val movie = MoviesRepository.getmovies()
        val list = movie.map { movies ->
            Movies(
                movies.id,
                movies.title,
                movies.plot,
                movies.genre,
                movies.rating,
                movies.year,
                movies.poster
            )
        }
        return list
    }

    data class MoviesFeed(val id: String, val title: String, val genre: String, val rating: Double, val poster: String)
}