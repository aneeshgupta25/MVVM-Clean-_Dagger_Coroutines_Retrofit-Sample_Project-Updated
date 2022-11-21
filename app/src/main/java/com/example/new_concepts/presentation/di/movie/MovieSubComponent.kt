package com.example.new_concepts.presentation.di.movie

import com.example.new_concepts.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent
    }
}