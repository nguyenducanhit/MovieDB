package com.example.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class Credit(
    @SerializedName("cast") val casters: MutableList<Caster>
)
