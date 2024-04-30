package com.example.myapplication.movieList.data.repository

import com.example.myapplication.movieList.data.local.movie.MovieDatabase
import com.example.myapplication.movieList.data.mappers.toModel
import com.example.myapplication.movieList.data.remote.MovieApi
import com.example.myapplication.movieList.domain.model.Model
import com.example.myapplication.movieList.domain.repository.MovieListRepository
import com.example.myapplication.movieList.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Model>>> {

        return flow {
            emit(Resource.Loading(true))
            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)
            val shouldLoadLocalMovie = localMovieList.isEmpty() && !forceFetchFromRemote

            if (shouldLoadLocalMovie) {
                emit(Resource.Success(
                    data = localMovieList.map { movieEntity ->
                        movieEntity.toModel(category)
                    }
                ))

                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Model>> {
        //TODO
    }

}