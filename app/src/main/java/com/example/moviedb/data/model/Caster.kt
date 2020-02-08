package com.example.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class Caster(
    @SerializedName("cast_id") val castId: Int,
    @SerializedName("character") val character: String,
    @SerializedName("profile_path") val profile: String,
    @SerializedName("name") val name: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("biography") val biography: String,
    @SerializedName("place_of_birth") val placeOfBirth: String,
    @SerializedName("gender") val gender: String
)
