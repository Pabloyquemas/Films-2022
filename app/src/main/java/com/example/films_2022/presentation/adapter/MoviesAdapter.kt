package com.example.films_2022.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.films_2022.R
import com.example.films_2022.domain.GetMoviesUseCase
import com.example.films_2022.domain.Movies

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>(){

    private val dataItems = mutableListOf<GetMoviesUseCase.MoviesFeed>()
    private var itemClick: ((String) -> Unit)? = null

    fun setOnClickItem(itemClick: (String) -> Unit){
        this.itemClick = itemClick
    }

    fun setDataItems(Movies: List<GetMoviesUseCase.MoviesFeed>){
        dataItems.clear()
        dataItems.addAll(Movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_movies_feed, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount(): Int = dataItems.size
}