package com.example.new_concepts.data.repository.movie

import android.util.Log
import com.example.new_concepts.data.model.movie.Movie
import com.example.new_concepts.data.repository.movie.datasource.MovieCacheDataSource
import com.example.new_concepts.data.repository.movie.datasource.MovieLocalDataSource
import com.example.new_concepts.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.new_concepts.domain.repository.MoviesRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MoviesRepository {

    //TAG for logs
    private val TAG = "MovieRepositoryImpl"
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    //will give list of movies fetched from remote web services
    suspend fun getMoviesFromAPI() : List<Movie> {
        var movieList = ArrayList<Movie>()
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            Log.v("Aneesh Movie", body?.movies.toString())
            if(body != null){
                movieList = body.movies as ArrayList<Movie>
            }
        } catch (e : Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return movieList
    }

    //will give list of movies stored in local database
    private suspend fun getMoviesFromLocalDB() : List<Movie>{
        var movieList = ArrayList<Movie>()
        try{
            movieList = movieLocalDataSource.getMoviesFromDB() as ArrayList<Movie>
        } catch(e : Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return movieList.ifEmpty {
            movieList = getMoviesFromAPI() as ArrayList<Movie>
            movieLocalDataSource.saveMoviesToDB(movieList)
            movieList
        }
    }

    //will give list of movies stored in cache to optimize app performance
    private suspend fun getMoviesFromCache() : List<Movie> {
        var movieList = ArrayList<Movie>()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache() as ArrayList<Movie>
        } catch (e : Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return movieList.ifEmpty {
            movieList = getMoviesFromLocalDB() as ArrayList<Movie>
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieList
        }
    }
}