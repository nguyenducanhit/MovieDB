package com.example.moviedb.data.service

import com.example.moviedb.data.model.Genre
import com.google.gson.annotations.SerializedName

class GenreResponse(
   @SerializedName("genres") val genres: List<Genre>
)