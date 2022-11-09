package com.example.films_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.films_2022.data.remote.Api.ApiClient

class MainActivity : AppCompatActivity() {

    val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            val movie = apiClient.getMovies()
            Log.d("@dev", "Movies: $movie")
        }
    }
}