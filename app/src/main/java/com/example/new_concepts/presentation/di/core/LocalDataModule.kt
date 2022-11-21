package com.example.new_concepts.presentation.di.core

import com.example.new_concepts.data.db.ArtistDao
import com.example.new_concepts.data.db.MovieDao
import com.example.new_concepts.data.db.TvShowsDao
import com.example.new_concepts.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.new_concepts.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.new_concepts.data.repository.movie.datasource.MovieLocalDataSource
import com.example.new_concepts.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.new_concepts.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao = movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao = artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao) : TvShowsLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowsDao = tvShowsDao)
    }

}