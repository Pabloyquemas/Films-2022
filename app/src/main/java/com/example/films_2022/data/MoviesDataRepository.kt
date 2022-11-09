package com.example.films_2022.data

import com.example.films_2022.data.local.MoviesLocalDataSource
import com.example.films_2022.data.remote.MoviesRemoteDataSource
import com.example.films_2022.domain.Movies
import com.example.films_2022.domain.MoviesRepository

class MoviesDataRepository (
    val localsource : MoviesLocalDataSource,
    val remoteSource : MoviesRemoteDataSource): MoviesRepository {
    override fun GetMovies(): List<Movies> {
        var movi = emptyList<Movies>()
        if (movi.isEmpty()){
            movi = remoteSource.getMovies()
            if (movi.isNotEmpty()){
                localsource.save(movi)
            }
        }
        return movi
    }

    override fun GetMoviesById(MoviesId: String): Movies? {
        return remoteSource.GetMoviesById(MoviesId)
    }

}