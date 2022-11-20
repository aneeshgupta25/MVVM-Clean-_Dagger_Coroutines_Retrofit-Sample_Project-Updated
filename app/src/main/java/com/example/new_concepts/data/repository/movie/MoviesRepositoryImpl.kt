package com.example.new_concepts.data.repository.movie

import com.example.new_concepts.data.model.movie.Movie
import com.example.new_concepts.domain.repository.MoviesRepository

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }
}