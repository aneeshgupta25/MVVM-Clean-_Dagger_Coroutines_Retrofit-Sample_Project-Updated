package com.example.new_concepts.data.repository.tvshow.datasource

import com.example.new_concepts.data.model.tvshow.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)
    suspend fun clearAll()
}