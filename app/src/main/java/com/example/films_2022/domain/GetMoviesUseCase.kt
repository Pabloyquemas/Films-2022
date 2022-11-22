package com.example.films_2022.domain

class GetMoviesUseCase(
    private val MoviesRepository : MoviesRepository
) {
     fun execute(): List<MoviesFeed> {
        val movie = MoviesRepository.getmovies()
        val list = movie.map { movies ->
            MoviesFeed(
                movies.id,
                movies.title,
                movies.plot,
                movies.rating,
                movies.poster
            )
        }
        return list
    }

    data class MoviesFeed(val id: String, val title: String, val genre: String, val rating: Double, val poster: String)
}