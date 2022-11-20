package com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.repository.tvshow

import com.example.mvvm_clean__dagger_coroutines_retrofit_sample_project_updated.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows() : Response<TvShowList>
}