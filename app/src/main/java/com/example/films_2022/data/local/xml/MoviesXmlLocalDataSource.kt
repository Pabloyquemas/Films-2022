package com.example.films_2022.data.local.xml

import android.content.SharedPreferences
import com.example.films_2022.data.local.MoviesLocalDataSource
import com.example.films_2022.domain.Movies
import com.google.gson.Gson

class MoviesXmlLocalDataSource(private val sharedPreferences: SharedPreferences): MoviesLocalDataSource {

    private val editor = sharedPreferences.edit()
    private val gson = Gson()
    override fun save(Movies: List<Movies>) {
        Movies.forEach { movies ->
            editor.putString(movies.id.toString(),gson.toJson(Movies))
        }
        editor.apply()
    }

    override fun getmovies(): List<Movies> {
        val movies: MutableList<Movies> = mutableListOf()
        sharedPreferences.all.forEach{ map ->
            movies.add(gson.fromJson(map.value as String, Movies::class.java))
        }
        return movies
    }

    override fun getmovie(movieId: String): Movies? {
        return sharedPreferences.getString(movieId.toString(), null)?.let {
            gson.fromJson(it, Movies::class.java)
        }
    }


}


