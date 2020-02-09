package com.example.moviedb.data.service

import com.example.moviedb.data.model.Credit
import com.example.moviedb.data.model.Genre
import com.example.moviedb.data.model.ProductionCompany
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val name: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("backdrop_path") val backdrop: String,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("genres") val genres: MutableList<Genre>,
    @SerializedName("production_companies") val companies: MutableList<ProductionCompany>,
    @SerializedName("credits") val credit: Credit
) {

    val genre
        get() = genres.joinToString { it.name }

    var trailer: String? = ""
}
