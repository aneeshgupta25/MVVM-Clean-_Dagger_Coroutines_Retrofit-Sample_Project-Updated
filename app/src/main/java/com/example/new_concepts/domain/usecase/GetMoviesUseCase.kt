package com.example.new_concepts.domain.usecase

import com.example.new_concepts.data.model.movie.Movie
import com.example.new_concepts.domain.repository.MoviesRepository

class GetMoviesUseCase(private val movieRepository: MoviesRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}