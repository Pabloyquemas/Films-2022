package com.example.films_2022.presentation

import android.content.Context
import android.content.SharedPreferences
import com.example.films_2022.data.MoviesDataRepository
import com.example.films_2022.data.local.xml.MoviesXmlLocalDataSource
import com.example.films_2022.data.remote.Api.MovieApiRemoteDataSource
import com.example.films_2022.data.remote.ApiClient
import com.example.films_2022.data.remote.MoviesRemoteDataSource
import com.example.films_2022.domain.GetMoviesUseCase
import com.example.films_2022.domain.MoviesRepository

class MoviesFactory {

    private fun getSharedPreferences(context: Context, namedSharedPreferences:String): SharedPreferences{
        return context.getSharedPreferences(namedSharedPreferences,Context.MODE_PRIVATE)
    }

    fun getMoviesViewModel(applicationContext: Context) = MoviesFeedViewModel(getMoviesUseCase(applicationContext))

    private fun getMoviesUseCase(context: Context): GetMoviesUseCase{
        return GetMoviesUseCase(
            getMoviesRepository(context)
        )
    }
    fun getMoviesRepository(context: Context): MoviesRepository{
        return MoviesDataRepository(
            MoviesXmlLocalDataSource(getSharedPreferences(context, "Movies")),
            MovieApiRemoteDataSource(ApiClient())
        )
    }
}