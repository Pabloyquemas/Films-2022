package com.example.films_2022.domain

class GetMoviesDetailUseCase(
    private val moviesRepository: MoviesRepository
) {
    fun execute(moviesId:String): Moviesbyid {
        val movies = moviesRepository.getmoviesbyId(moviesId)!!
        return Moviesbyid(
            movies.id,
            movies.title,
            movies.plot,
            movies.year,
            movies.poster
        )
    }

    data class Moviesbyid(val id: String, val title: String, val plot: String, val year: String, val poster: String)
}