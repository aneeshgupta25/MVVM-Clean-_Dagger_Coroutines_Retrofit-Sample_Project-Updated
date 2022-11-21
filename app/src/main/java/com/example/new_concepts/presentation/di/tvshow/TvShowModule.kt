package com.example.new_concepts.presentation.di.tvshow

import com.example.new_concepts.domain.usecase.GetTvShowsUseCase
import com.example.new_concepts.domain.usecase.UpdateTvShowsUseCase
import com.example.new_concepts.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase, updateTvShowsUseCase
        )
    }

}