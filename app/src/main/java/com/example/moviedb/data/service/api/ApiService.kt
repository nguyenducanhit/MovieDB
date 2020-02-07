package com.example.moviedb.data.service.api

import com.example.moviedb.data.model.Movie
import com.example.moviedb.data.service.GenreResponse
import com.example.moviedb.data.service.ListMovieResponse
import com.example.moviedb.data.service.MovieDetailResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list?api_key=3956f50a726a2f785334c24759b97dc6")
    fun getGenres(): Single<GenreResponse>

    @GET("discover/movie?api_key=3956f50a726a2f785334c24759b97dc6")
    fun getMoviesByGenre(@Query("page") page: Int, @Query("with_genres") genreId: Int): Single<ListMovieResponse>

    @GET("movie/{type}?api_key=3956f50a726a2f785334c24759b97dc6")
    fun getMoviesByType(@Path("type") type: String, @Query("page") page: Int): Single<ListMovieResponse>

    @GET("movie/{movie_id}?api_key=3956f50a726a2f785334c24759b97dc6&append_to_response=videos,credits,images")
    fun getMovie(@Path("movie_id") movieId: Int): Single<MovieDetailResponse>
}
