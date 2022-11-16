package com.example.films_2022.data.remote.Api

import com.example.films_2022.domain.Movies

fun MoviesApiModel.toDomain(): Movies{
    return Movies(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}