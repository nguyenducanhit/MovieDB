package com.example.moviedb.data.service

import com.example.moviedb.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_pages") val totalPage: Int,
    @SerializedName("results") val movies: List<Movie>
)
