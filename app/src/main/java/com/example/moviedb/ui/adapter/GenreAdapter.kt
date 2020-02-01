package com.example.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviedb.R
import com.example.moviedb.data.model.Genre
import com.example.moviedb.databinding.ItemGenreBinding

class GenreAdapter(val genres: List<Genre>) : Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemGenreBinding>(LayoutInflater.from(parent.context), R.layout.item_genre, parent, false)
        return GenreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as GenreViewHolder).bindData(genres[position])
    }

    class GenreViewHolder(private val binding: ItemGenreBinding) : ViewHolder(binding.root){
        fun bindData(genre: Genre){
            binding.textTitleGenre.text = genre.name
        }
    }
}