package com.example.films_2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.loadUrl
import com.example.films_2022.databinding.ViewItemMoviesDetailBinding
import com.example.films_2022.domain.GetMoviesUseCase

class MoviesDetailViewHolder(private val view:View): RecyclerView.ViewHolder(view) {

    fun bind (Movie: String){
        val item = ViewItemMoviesDetailBinding.bind(view)
        item.title.text = Movie.title
        item.year.text = Movie.year
        item.genre.text = Movie.genre
        item.poster.loadUrl(Movie.poster)

    }
}