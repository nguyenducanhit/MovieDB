package com.example.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.data.model.Movie
import com.example.moviedb.databinding.ItemMovieBinding
import com.example.moviedb.utils.ImageUtils

class MovieAdapter : Adapter<ViewHolder>() {
    private val movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as MovieViewHolder).bindData(movies[position])
    }

    fun addMovies(data: List<Movie>) {
        val lastItem = movies.size
        movies.addAll(data)
        notifyItemInserted(lastItem)
    }

    fun setMovies(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : ViewHolder(binding.root) {
        fun bindData(movie: Movie) {
            with(binding) {
                textTitle.text = movie.name
                Glide.with(root).load(ImageUtils.getLink(movie.backdrop))
                    .placeholder(R.drawable.ic_launcher_background).into(imagePoster)
                textVoteAverage.text = movie.voteAverage.toString()
            }
        }
    }
}
