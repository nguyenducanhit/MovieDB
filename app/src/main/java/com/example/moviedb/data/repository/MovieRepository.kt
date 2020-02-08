package com.example.moviedb.data.repository

import com.example.moviedb.data.service.ListMovieResponse
import com.example.moviedb.data.service.MovieDetailResponse
import com.example.moviedb.data.service.api.ApiService
import io.reactivex.Single

class MovieRepository(
    private val service: ApiService
) {

    fun getMovieByGenre(genreId: Int, page: Int): Single<ListMovieResponse> {
        return service.getMoviesByGenre(page, genreId)
    }

    fun getMovieByType(type: String, page: Int): Single<ListMovieResponse> {
        return service.getMoviesByType(type, page)
    }

    fun getMovie(movieId: Int): Single<MovieDetailResponse> {
        return service.getMovie(movieId)
    }

    companion object {
        private var movieRepository: MovieRepository? = null

        fun getInstance(service: ApiService): MovieRepository =
            movieRepository ?: MovieRepository(service).also { movieRepository = it }
    }
}
