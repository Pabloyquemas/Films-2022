package com.example.films_2022.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM $TABLE_NAME_FILMS")
    fun getmovies(): List<FilmEntity>

    @Insert
    fun save(filmEntity: FilmEntity)
}