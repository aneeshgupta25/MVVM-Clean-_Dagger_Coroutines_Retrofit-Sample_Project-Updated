package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.movie

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie.Movie
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository.MoviesRepository

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }
}