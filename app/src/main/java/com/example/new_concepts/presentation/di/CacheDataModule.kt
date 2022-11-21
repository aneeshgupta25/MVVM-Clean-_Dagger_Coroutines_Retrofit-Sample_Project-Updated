package com.example.new_concepts.presentation.di

import com.example.new_concepts.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.new_concepts.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.new_concepts.data.repository.movie.datasource.MovieCacheDataSource
import com.example.new_concepts.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.new_concepts.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowsCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

}