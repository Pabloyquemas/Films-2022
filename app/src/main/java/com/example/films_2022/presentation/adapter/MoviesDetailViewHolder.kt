package com.example.films_2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.loadUrl
import com.example.films_2022.databinding.ViewItemMoviesDetailBinding
import com.example.films_2022.domain.GetMoviesDetailUseCase
import com.example.films_2022.domain.GetMoviesUseCase

class MoviesDetailViewHolder(private val view:View): RecyclerView.ViewHolder(view) {

    fun bind (movie: GetMoviesDetailUseCase.Moviesbyid){
        val item = ViewItemMoviesDetailBinding.bind(view)
        item.title.text = movie.title
        item.genre.text = movie.genre
        item.year.text = movie.year
        item.poster.loadUrl(movie.poster)
    }
}