package com.example.myapplication.movieList.data.remote.respond

class MovieListDto (
    val page: Int,
    val results: List<MovieDto>,
    val totalPage: Int,
    val total_results: Int
)