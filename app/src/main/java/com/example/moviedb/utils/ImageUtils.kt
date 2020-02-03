package com.example.moviedb.utils

object ImageUtils {

    private const val BASE_URL_IMAGE = "http://image.tmdb.org/t/p/original"

    fun getLink(fileName: String?): String = fileName?.let {
        BASE_URL_IMAGE + it
    } ?: ""
}
