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

    fun getmovies(): List<MoviesApiModel>{
        val movies = apiServices.getmovies()
        val response = movies.execute()
        if (response.isSuccessful){
            return response.body() ?: emptyList()
        }
        return emptyList()
    }
    fun getmoviesbyId(moviesId: String): MoviesApiModel?{
        val call = apiServices.getmovie(moviesId).execute()
        return call.body()
}
}