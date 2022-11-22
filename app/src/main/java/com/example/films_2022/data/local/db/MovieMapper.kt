package com.example.films_2022.data.local.db

import com.example.films_2022.domain.Movies

fun FilmEntity.toDomain(): Movies = Movies(
    this.id, this.title, this.plot, this.genre,this.rating,this.year, this.poster
)

fun Movies.toEntity() = FilmEntity(
    this.id,
    this.title,
    this.plot,
    this.genre,
    this.rating,
    this.year,
    this.poster
)