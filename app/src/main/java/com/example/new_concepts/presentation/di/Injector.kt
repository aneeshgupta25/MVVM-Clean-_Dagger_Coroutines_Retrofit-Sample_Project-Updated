package com.example.new_concepts.presentation.di

import com.example.new_concepts.presentation.di.artist.ArtistSubComponent
import com.example.new_concepts.presentation.di.movie.MovieSubComponent
import com.example.new_concepts.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}