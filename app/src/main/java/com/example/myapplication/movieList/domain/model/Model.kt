package com.example.myapplication.movieList.domain.model


data class Model(
    val adult: Boolean?,
    val backdrop_path: String,
    val overview: String,
    val genre_ids: List<Int>,
    val original_language: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val id: Int?,
    val original_title: String,
    val category: String
)