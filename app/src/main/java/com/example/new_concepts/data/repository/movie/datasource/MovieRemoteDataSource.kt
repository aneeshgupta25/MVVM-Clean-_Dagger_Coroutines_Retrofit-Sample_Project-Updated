package com.example.new_concepts.data.repository.movie.datasource

import com.example.new_concepts.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}