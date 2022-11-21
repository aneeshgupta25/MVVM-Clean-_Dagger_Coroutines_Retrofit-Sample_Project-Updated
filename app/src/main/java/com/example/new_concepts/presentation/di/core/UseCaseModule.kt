package com.example.new_concepts.presentation.di.core

import com.example.new_concepts.domain.repository.ArtistsRepository
import com.example.new_concepts.domain.repository.MoviesRepository
import com.example.new_concepts.domain.repository.TvShowsRepository
import com.example.new_concepts.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(moviesRepository: MoviesRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(moviesRepository: MoviesRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository) : UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

}