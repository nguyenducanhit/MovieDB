package com.example.moviedb.ui.utils

object ImageUtils {

    private const val BASE_URL_IMAGE = "http://image.tmdb.org/t/p/original"

    fun getLink(fileName: String) = BASE_URL_IMAGE + fileName
}