package com.example.new_concepts.data.repository.tvshow

import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.domain.repository.TvShowsRepository

class TvShowRepositoryImpl : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}