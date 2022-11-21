package com.example.new_concepts.presentation.di.core

import com.example.new_concepts.data.api.TMDBService
import com.example.new_concepts.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.new_concepts.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.new_concepts.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.new_concepts.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.new_concepts.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService : TMDBService) : ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowsRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService = tmdbService, apiKey = apiKey)
    }

}