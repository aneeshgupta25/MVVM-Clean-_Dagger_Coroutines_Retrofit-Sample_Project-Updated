package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}