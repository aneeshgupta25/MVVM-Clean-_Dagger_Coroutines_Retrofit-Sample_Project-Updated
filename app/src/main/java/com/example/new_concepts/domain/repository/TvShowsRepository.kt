package com.example.new_concepts.domain.repository

import com.example.new_concepts.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}