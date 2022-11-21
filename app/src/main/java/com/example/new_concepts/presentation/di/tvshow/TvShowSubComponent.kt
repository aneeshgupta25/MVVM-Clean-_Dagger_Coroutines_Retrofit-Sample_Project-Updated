package com.example.new_concepts.presentation.di.tvshow

import com.example.new_concepts.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }

}