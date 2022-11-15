package com.example.films_2022.data.remote.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("movies")
    fun getmovies(): Call<List<MoviesApiModel>>


    @GET("movies/{moviesId}")
    fun getmovie(@Path("moviesId") moviesId: String): Call<MoviesApiModel>
}