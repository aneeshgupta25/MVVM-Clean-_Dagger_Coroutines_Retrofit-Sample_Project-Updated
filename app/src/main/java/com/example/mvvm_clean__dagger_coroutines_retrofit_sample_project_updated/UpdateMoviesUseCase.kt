package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MoviesRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}