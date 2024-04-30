package com.example.myapplication.movieList.domain.repository

import com.example.myapplication.movieList.domain.model.Model
import com.example.myapplication.movieList.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Model>>>

    suspend fun getMovie(id: Int): Flow<Resource<Model>>
}