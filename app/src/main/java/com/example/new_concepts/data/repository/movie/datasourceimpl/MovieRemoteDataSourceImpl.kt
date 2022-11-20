package com.example.new_concepts.data.repository.movie.datasourceimpl

import com.example.new_concepts.data.api.TMDBService
import com.example.new_concepts.data.model.movie.MovieList
import com.example.new_concepts.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey = apiKey)
}