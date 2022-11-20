package com.example.new_concepts.data.repository.movie.datasourceimpl

import com.example.new_concepts.data.model.movie.Movie
import com.example.new_concepts.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = moviesList

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

}