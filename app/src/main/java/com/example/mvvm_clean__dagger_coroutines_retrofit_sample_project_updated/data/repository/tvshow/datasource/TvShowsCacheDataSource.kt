package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.tvshow.datasource

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow

interface TvShowsCacheDataSource {
    suspend fun saveTvShowsToCache(tvShows : List<TvShow>)
    suspend fun getTvShowsFromCache() : List<TvShow>
}