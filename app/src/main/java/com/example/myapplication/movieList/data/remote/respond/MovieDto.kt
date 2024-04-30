package com.example.myapplication.movieList.data.remote.respond

data class MovieDto(
    val adult: Boolean?,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val overview: String,
    val id: Int,
    val original_language: String?,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val original_title: String?,
    val vote_count: Int?
)