package com.example.new_concepts.presentation.di.movie

import com.example.new_concepts.domain.usecase.GetMoviesUseCase
import com.example.new_concepts.domain.usecase.UpdateMoviesUseCase
import com.example.new_concepts.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}