package com.example.myapplication.movieList.util

sealed class Screen(
    val rout: String
) {
    data object Home: Screen("main")
    data object PopularMovieList: Screen("PopularMovie")
    data object UpcomingMovieList: Screen("upcomingMovie")
    data object Details: Screen("details")
}