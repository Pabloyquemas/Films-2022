package com.example.films_2022.data.remote.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val baseEndPoint: String = "https://movies-and-shows-api.cyclic.app/"

    private val apiServices: ApiServices


    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getMovies(): List<MoviesApiModel>{
        val movies = apiServices.GetMovies()
        val response = movies.execute()
        if (response.isSuccessful){
            return response.body() ?: emptyList()
        }
        return emptyList()
    }
    fun GetMoviesById(moviesId: String): MoviesApiModel?{
        val call = apiServices.GetMovie(moviesId).execute()
        return call.body()
}
}