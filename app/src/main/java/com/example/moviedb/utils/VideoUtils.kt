package com.example.moviedb.utils

object VideoUtils {
    private const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
    fun getUrl(url: String?): String = url?.let { YOUTUBE_URL + url } ?: ""
}