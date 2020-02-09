package com.example.moviedb.data.service

import com.example.moviedb.data.model.Trailer
import com.google.gson.annotations.SerializedName

class TrailerResponse(
    @SerializedName("id") val idMovie: Int,
    @SerializedName("results") val trailers: MutableList<Trailer>
)