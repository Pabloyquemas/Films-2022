package com.example.films_2022.data.remote.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("movies.json")
    fun GetMovies(): Call<List<MoviesApiModel>>

    @GET("id/{movieId}.json")
    fun GetMovie(@Path("movieId") movieID: String): Call<MoviesApiModel>
}