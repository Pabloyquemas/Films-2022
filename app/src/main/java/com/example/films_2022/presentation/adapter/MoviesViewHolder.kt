package com.example.films_2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.loadUrl
import com.example.films_2022.databinding.ViewItemMoviesFeedBinding
import com.example.films_2022.domain.GetMoviesUseCase
import com.example.films_2022.domain.Movies

class MoviesViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind (Movies: GetMoviesUseCase.MoviesFeed, itemClick: ((String) -> Unit)?){
        val item = ViewItemMoviesFeedBinding.bind(view)
        item.title.text = Movies.title
        item.rating.text= Movies.rating.toString()
        item.genre.text = Movies.genre
        item.poster.loadUrl(Movies.poster)
        view.setOnClickListener{
            itemClick?.invoke(Movies.id)
        }
    }
}