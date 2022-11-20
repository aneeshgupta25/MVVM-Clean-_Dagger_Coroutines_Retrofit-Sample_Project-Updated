package com.example.new_concepts.data.repository.movie.datasource

import com.example.new_concepts.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}