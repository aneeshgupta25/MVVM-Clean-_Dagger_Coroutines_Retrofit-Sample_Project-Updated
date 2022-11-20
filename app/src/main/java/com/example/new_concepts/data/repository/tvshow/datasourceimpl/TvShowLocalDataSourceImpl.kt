package com.example.new_concepts.data.repository.tvshow.datasourceimpl

import com.example.new_concepts.data.db.TvShowsDao
import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowsDao: TvShowsDao) : TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowsDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }



}