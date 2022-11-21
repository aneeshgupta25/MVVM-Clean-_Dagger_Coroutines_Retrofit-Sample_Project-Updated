package com.example.new_concepts.presentation.di.core

import com.example.new_concepts.presentation.di.artist.ArtistSubComponent
import com.example.new_concepts.presentation.di.movie.MovieSubComponent
import com.example.new_concepts.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory

}