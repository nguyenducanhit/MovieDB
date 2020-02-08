package com.example.moviedb.data.service

import com.example.moviedb.data.model.Credit
import com.example.moviedb.data.model.Genre
import com.example.moviedb.data.model.ProductionCompany
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id") open val id: Int,
    @SerializedName("title") open val name: String,
    @SerializedName("vote_average") open val voteAverage: Float,
    @SerializedName("overview") open val overview: String,
    @SerializedName("poster_path") open val poster: String,
    @SerializedName("backdrop_path") open val backdrop: String,
    @SerializedName("vote_count") open val voteCount: Int,
    @SerializedName("release_date") open val releaseDate: String,
    @SerializedName("genres") val genres: MutableList<Genre>,
    @SerializedName("production_companies") val companies: MutableList<ProductionCompany>,
    @SerializedName("credits") val credit: Credit
) {

    val genre
        get() = genres.joinToString { it.name }
}
