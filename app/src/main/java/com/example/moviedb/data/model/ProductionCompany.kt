package com.example.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logo: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
)
