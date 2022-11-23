package com.example.films_2022.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.films_2022.R

class MoviesDetailAdapter : RecyclerView.Adapter<MoviesDetailViewHolder>() {

    private val dataItems = mutableListOf<String>()

    fun setDataItems(details: List<String>){
        dataItems.clear()
        dataItems.addAll(details)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_movies_detail, parent, false)
        return MoviesDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesDetailViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }

    override fun getItemCount(): Int = dataItems.size
}