package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.tvshow

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShow
import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.domain.repository.TvShowsRepository

class TvShowRepositoryImpl : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}