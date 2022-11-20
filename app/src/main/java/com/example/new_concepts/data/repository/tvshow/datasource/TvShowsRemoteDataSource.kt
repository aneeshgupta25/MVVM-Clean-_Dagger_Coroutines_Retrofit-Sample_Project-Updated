package com.example.new_concepts.data.repository.tvshow.datasource

import com.example.new_concepts.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows() : Response<TvShowList>
}