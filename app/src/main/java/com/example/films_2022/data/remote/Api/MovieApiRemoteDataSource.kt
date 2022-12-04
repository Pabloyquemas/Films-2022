package com.example.films_2022.data.remote.Api

import com.example.films_2022.data.remote.ApiClient
import com.example.films_2022.data.remote.MoviesRemoteDataSource
import com.example.films_2022.domain.Movies

class MovieApiRemoteDataSource(val apiClient: ApiClient): MoviesRemoteDataSource {
    override fun getMovies(): List<Movies> {
        val movies = apiClient.getMovies()
        return movies.map {
            it.toDomain()
        }
    }

    override fun getmoviesbyId(movieId: String): Movies? {
        return apiClient.GetMoviesById(movieId)?.toDomain()
    }
}
