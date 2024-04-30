package com.example.myapplication.movieList.data.mappers

import android.view.Display.Mode
import com.example.myapplication.movieList.data.local.movie.MovieEntity
import com.example.myapplication.movieList.data.remote.respond.MovieDto
import com.example.myapplication.movieList.domain.model.Model

fun MovieDto.toMovieEntity(
    category: String
): MovieEntity{
    return MovieEntity(
        adult = adult,
        backdrop_path = backdrop_path,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        popularity = popularity,
        vote_count = vote_count ?: 0,
        id = id ?: -1,
        original_title = original_title ?: "",
        video = video ?: false,
        category = category,

        genre_ids = try {
            genre_ids.joinToString { "," }
        }
    )
}

fun MovieEntity.toModel(
    category: String
): Model {
    return Model(
        backdrop_path = backdrop_path,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        popularity = popularity,
        vote_count = vote_count,
        video = video,
        id = id,
        adult = adult,
        original_title = original_title,
        category = category,

        genre_ids = try {
            genre_ids.split (",") ?: "-1"
        } catch (e: Exception) {
            "-1"
        }
    )
}