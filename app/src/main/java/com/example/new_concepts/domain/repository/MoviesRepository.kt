package com.example.new_concepts.domain.repository

import com.example.new_concepts.data.model.movie.Movie

interface MoviesRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}