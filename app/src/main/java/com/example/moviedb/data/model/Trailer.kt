package com.example.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("id") val id: String,
    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)