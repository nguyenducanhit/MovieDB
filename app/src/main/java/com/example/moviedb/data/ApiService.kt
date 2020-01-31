package com.example.moviedb.data

import com.example.moviedb.data.model.Genre
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET
    fun getGenres(): Single<List<Genre>>
}