package com.example.new_concepts.data.repository.tvshow

import android.util.Log
import com.example.new_concepts.data.model.tvshow.TvShow
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.new_concepts.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowLocalDataSource: TvShowsLocalDataSource,
    private val tvShowCacheDataSource: TvShowsCacheDataSource
) : TvShowsRepository {

    private val TAG = "TvShowRepositoryImpl"

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        var tvShowList = ArrayList<TvShow>()
        try {
            val tvShowListResponse = tvShowRemoteDataSource.getTvShows()
            val tvShowBody = tvShowListResponse.body()
            if (tvShowBody != null) {
                tvShowList = tvShowBody.tvShows as ArrayList<TvShow>
            }
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        var tvShowList = ArrayList<TvShow>()
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB() as ArrayList<TvShow>
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return tvShowList.ifEmpty {
            val newTvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.clearAll()
            tvShowLocalDataSource.saveTvShowsToDB(newTvShowList)
            newTvShowList
        }
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        var tvShowList = ArrayList<TvShow>()
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache() as ArrayList<TvShow>
        } catch (e: Exception) {
            Log.v(TAG, "Something went wrong!!!")
        }
        return tvShowList.ifEmpty {
            val newTvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)
            newTvShowList
        }
    }
}