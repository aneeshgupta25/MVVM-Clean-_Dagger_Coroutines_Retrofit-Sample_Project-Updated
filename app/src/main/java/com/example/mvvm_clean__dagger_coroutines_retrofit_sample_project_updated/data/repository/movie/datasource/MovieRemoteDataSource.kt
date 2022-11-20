package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.movie.datasource

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}