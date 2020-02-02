package com.example.moviedb.data.repository

import com.example.moviedb.data.service.MoviesResponse
import com.example.moviedb.data.service.api.ApiService
import io.reactivex.Single

class MovieRepository(
    private val service: ApiService
) {

    fun getMovieByGenre(genreId: Int, page: Int): Single<MoviesResponse> {
        return service.getMoviesByGenre(page, genreId)
    }

    fun getMovieByType(type: String, page: Int): Single<MoviesResponse> {
        return service.getMoviesByType(type, page)
    }

    companion object {
        private var movieRepository: MovieRepository? = null

        fun getInstance(service: ApiService): MovieRepository =
            movieRepository ?: MovieRepository(service).also { movieRepository = it }
    }
}
