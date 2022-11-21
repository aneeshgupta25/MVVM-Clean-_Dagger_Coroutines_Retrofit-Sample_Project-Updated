package com.example.new_concepts.presentation.di

import com.example.new_concepts.data.repository.artist.ArtistsRepositoryImpl
import com.example.new_concepts.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.new_concepts.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.new_concepts.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.new_concepts.data.repository.movie.MoviesRepositoryImpl
import com.example.new_concepts.data.repository.movie.datasource.MovieCacheDataSource
import com.example.new_concepts.data.repository.movie.datasource.MovieLocalDataSource
import com.example.new_concepts.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.new_concepts.data.repository.tvshow.TvShowRepositoryImpl
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.new_concepts.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.new_concepts.domain.repository.ArtistsRepository
import com.example.new_concepts.domain.repository.MoviesRepository
import com.example.new_concepts.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            movieCacheDataSource = movieCacheDataSource,
            movieLocalDataSource = movieLocalDataSource,
            movieRemoteDataSource = movieRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(
            artistRemoteDataSource = artistRemoteDataSource,
            artistLocalDataSource = artistLocalDataSource,
            artistCacheDataSource = artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource = tvShowsRemoteDataSource,
            tvShowLocalDataSource = tvShowsLocalDataSource,
            tvShowCacheDataSource = tvShowsCacheDataSource
        )
    }

}