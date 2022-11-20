package com.example.new_concepts.data.repository.tvshow.datasource

import com.example.new_concepts.data.model.tvshow.TvShow

interface TvShowsCacheDataSource {
    suspend fun saveTvShowsToCache(tvShows : List<TvShow>)
    suspend fun getTvShowsFromCache() : List<TvShow>
}