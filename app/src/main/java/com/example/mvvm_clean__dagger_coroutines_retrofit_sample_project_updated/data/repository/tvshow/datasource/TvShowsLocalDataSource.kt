package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.tvshow.datasource

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)
    suspend fun clearAll()
}