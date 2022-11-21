package com.example.new_concepts.presentation.di.artist

import com.example.new_concepts.domain.usecase.GetArtistsUseCase
import com.example.new_concepts.domain.usecase.UpdateArtistsUseCase
import com.example.new_concepts.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}