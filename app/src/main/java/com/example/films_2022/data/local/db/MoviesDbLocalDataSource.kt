package com.example.films_2022.data.local.db

import com.example.films_2022.data.local.MoviesLocalDataSource
import com.example.films_2022.domain.Movies

class MoviesDbLocalDataSource(private val dao: MovieDao): MoviesLocalDataSource {
    override fun save(Movies: List<Movies>) {
        Movies.forEach { movies ->
            dao.save(movies.toEntity())
        }
    }

    override fun getmovies(): List<Movies> {
        return dao.getmovies().map {
            it.toDomain()
        }
    }

    override fun getmovie(movieId: String): Movies? {
        TODO("Not yet implemented")
    }
}