package com.example.films_2022.data

import com.example.films_2022.data.remote.MoviesRemoteDataSource
import com.example.films_2022.domain.Movies
import com.example.films_2022.domain.MoviesRepository

class MoviesDataRepository (
    val remoteSource : MoviesRemoteDataSource): MoviesRepository {

    override fun getmovies(): List<Movies> {
        TODO("Not yet implemented")
    }

    override fun getmoviesbyId(MoviesId: String): Movies? {
        TODO("Not yet implemented")
    }

}