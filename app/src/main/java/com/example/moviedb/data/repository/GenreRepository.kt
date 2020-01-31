package com.example.moviedb.data.repository

import com.example.moviedb.data.service.api.ApiService
import com.example.moviedb.data.model.Genre
import io.reactivex.Single

class GenreRepository(private val service: ApiService) {

    fun getGenres(): Single<List<Genre>> {
        return service.getGenres().map { it.genres }
    }

    companion object {
        var genreRepository: GenreRepository? = null

        fun getInstance(service: ApiService): GenreRepository =
            genreRepository ?: GenreRepository(service).also { genreRepository = it }
    }
}
