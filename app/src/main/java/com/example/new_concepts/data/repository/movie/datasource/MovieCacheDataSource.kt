package com.example.new_concepts.data.repository.movie.datasource

import com.example.new_concepts.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}