package com.example.new_concepts.data.repository.tvshow.datasourceimpl

import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsCacheDataSource

class TvShowCacheDataSourceImpl() : TvShowsCacheDataSource {
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }
}