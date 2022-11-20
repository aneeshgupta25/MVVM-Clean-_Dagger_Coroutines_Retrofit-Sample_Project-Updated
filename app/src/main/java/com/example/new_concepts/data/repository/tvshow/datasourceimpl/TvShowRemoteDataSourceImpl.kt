package com.example.new_concepts.data.repository.tvshow.datasourceimpl

import com.example.new_concepts.data.api.TMDBService
import com.example.new_concepts.data.model.tvshow.TvShowList
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val apiKey: String,
    private val tmdbService: TMDBService
) : TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}