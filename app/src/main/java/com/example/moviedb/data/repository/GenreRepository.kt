package com.example.moviedb.data.repository

import com.example.moviedb.data.ApiService
import com.example.moviedb.data.model.Genre
import io.reactivex.Single

class GenreRepository(private val service: ApiService) {

    companion object{
        lateinit var genreRepository: GenreRepository

        fun getInstance(service: ApiService): GenreRepository{
            return GenreRepository(service)
        }
    }
    fun getGenres(): Single<List<Genre>>{
        return service.getGenres()
    }
}