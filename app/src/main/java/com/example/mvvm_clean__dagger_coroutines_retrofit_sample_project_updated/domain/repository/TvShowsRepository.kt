package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}